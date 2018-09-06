package springbook.user.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

import java.security.interfaces.RSAKey;
import java.sql.*;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;


public class UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        class AddStatement implements StatementStrategy { // add 메소드 내부에 선언된 로컬 클래스
            User user;

            public AddStatement(User user) {
                this.user = user;
            }

            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement(
                        "insert into tbl_users(id, name, password) values(?,?,?)");

                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword()); /// 그런데 user는 어디서 가져올까?


                return ps;
            }
        }

        StatementStrategy st = new AddStatement(user);
        jdbcContextWithStatementStrategy(st);
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

            StatementStrategy st = new DeleteAllStatement(); // 선정한 전략 클래스의 오브젝트 생성
            jdbcContextWithStatementStrategy(st); // 컨텍스트 호출. 전략 오브젝트 전달

    }

    public int getCount() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("select count(*) from tbl_users");

            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) { try {rs.close();} catch (SQLException e) {} }
            if (ps != null) { try {ps.close();} catch (SQLException e) {} }
            if (c != null) { try {c.close();} catch (SQLException e) {} }
        }
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        // 클라이언트가 컨텍셔트를 호출할 때 넘겨줄 파라미터 :  StatementStrategy stmt

        try {
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if (c != null) { try { c.close(); } catch (SQLException e) {} }
        }
    }
}
