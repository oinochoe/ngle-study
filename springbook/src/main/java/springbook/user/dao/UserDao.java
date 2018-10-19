package springbook.user.dao;

import com.mysql.jdbc.MysqlErrorNumbers;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springbook.user.domain.User;

import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        // DataSource 오브젝트는 JdbcTemplate을 만든 후에는 사용하지 않으니 저장해두지 않아도 된다.
    }

    private RowMapper<User> userMapper =
        new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        };

    // 아이디 중복 시 사용하는 예외
    public class DuplicateUserIdException extends RuntimeException {
        public DuplicateUserIdException(Throwable cause) {
            super(cause);
        }
    }

    /**
     * 예외 전략 추가
     * 중복 키 예외의 전환
     * */
    public void add(final User user) throws DuplicateUserIdException {
        try {
            this.jdbcTemplate.update("insert into tbl_users(id, name, password) values(?,?,?)",
                    user.getId(), user.getName(), user.getPassword());
        } catch (DuplicateKeyException e) {
            /**
             * 로그 남기는 등의 필요한 작업
             * 예외 전환할 때 원인이 되는 예외를 중첩하는 것이 좋다.
             * */
            throw new DuplicateUserIdException(e);
        }
    }

    public User get(String id) { return this.jdbcTemplate.queryForObject("select * from tbl_users where id = ?", new Object[]{id}, this.userMapper); }

    public List<User> getAll() { return this.jdbcTemplate.query("select * from tbl_users order by id", this.userMapper); }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from tbl_users");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForInt("select count(*) from tbl_users");
    }
}
