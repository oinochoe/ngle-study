package springbook.user.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

import java.sql.*;
import javax.sql.DataSource;


public class UserDao {

    private DataSource dataSource;
    private JdbcContext jdbcContext;

    public void setDataSource(DataSource dataSource) { // 수정자 메소드이면서 JdbcContext에 대한 생성, DI 작업을 동시에 수행
        this.jdbcContext = new JdbcContext(); // JdbcContext 생성(IOC)
        this.jdbcContext.setDataSource(dataSource); // 의존 오브젝트 주입(DI)
        this.dataSource = dataSource; // 아직 JdbcContext를 적용하지 않은 메소드를 위해 저장해둔다.
        // 먼저 JdbcContext의 오브젝트를 만들어서 인스턴스 변수에 저장해두고, JdbcContext에 UserDao가 DI 받은
        // DataSource 오브제를 주입해주면 완벽한 DI가 완성된다.
    }


    public void add(final User user) throws SQLException {
        this.jdbcContext.workWithStatementStrategy(
        new StatementStrategy() {
                public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                    PreparedStatement ps = c.prepareStatement(
                            "insert into tbl_users(id, name, password) values(?,?,?)");
                    ps.setString(1, user.getId());
                    ps.setString(2, user.getName());
                    ps.setString(3, user.getPassword());

                    return ps;
                }
            }
        );
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
        this.jdbcContext.workWithStatementStrategy(
            new StatementStrategy() {
                public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                    return c.prepareStatement("delete from tbl_users");
                }
            }
        );
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
