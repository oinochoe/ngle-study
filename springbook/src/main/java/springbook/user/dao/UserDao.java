package springbook.user.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.SQLException;


public class UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into tbl_users(id, name, password) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException {
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from tbl_users where id = ?");

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        User user = null; // User는 NULL 상태로 초기화 해놓는다.
        if (rs.next()) { // id를 조건으로 한 쿼리의 결과가 있으면 User 오브제를 만들고 값을 넣어준다.
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        if (user == null) throw new EmptyResultDataAccessException(1);
        // 결과가 없으면 User는 null 상태 그대로 일 것이다. 이를 확인해서 예외를 던져준다.

        return user;
    }

    public void deleteAll() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try { // 예외가 발생할 가능성이 있는 코드를 모두 try 블럭으로 묶어준다
            c = dataSource.getConnection();
            ps = c.prepareStatement("delete from tbl_users");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
            /*
             * 예외가 발생했을 때 부가적으로 작업을 해줄 수 있도록 catch 블록을 둔다.
             * 예외를 다시 메서드 밖으로 던지는 것 밖에 없다.
             */
        } finally { // finally이므로 try 블록에서 예외가 발생했을 때나 안 했을 때나 모두 실행
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    /*
                     * ps.close() 메소드에서도 SQL Exception이 발생할 수 있기 때문에 이를 잡아줘야 한다.
                     * 그렇지 않으면 Connection을 close() 하지 못하고 메소드를 빠져나갈 수 있다.
                     */
                }
            }
            if (c != null) {
                try {
                    c.close(); //connection 반환
                } catch (SQLException e) {

                }
            }
        }
    }

    public int getCount() throws SQLException {
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select count(*) from tbl_users");

        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();

        return count;
    }
}
