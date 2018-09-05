package springbook.user;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {

    UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before // junit 이 제공하는 어노테이션 @Test 메소드가 실행되기 전에 먼저 실행돼야 하는 메소드를 정의
    public void setUp() {

        dao = new UserDao();
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:mysql://localhost:3306/users?useSSL=false&amp;serverTimezone=UTC","root","admin",true);
        dao.setDataSource(dataSource);

        this.user1 = new User("yeongmin","yeongmin122223","spring1");
        this.user2 = new User("yeongmin2","yeongmin123222","spring2");
        this.user3 = new User("yeongmin3","yeongmin1233333","spring3");

    }

    @Test
    public void addAndGet() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }

    @Test
    public void count() throws SQLException {
        System.out.println(dao.getCount());
        dao.deleteAll();

        assertThat(dao.getCount(), is(0));
        System.out.println(dao.getCount());

        dao.add(user1);
        assertThat(dao.getCount(), is(1));
        System.out.println(dao.getCount());

        dao.add(user2);
        assertThat(dao.getCount(), is(2));
        System.out.println(dao.getCount());

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
        System.out.println(dao.getCount());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id"); // 이 메소드 실행 중에 예외가 발생하지 않으면 테스트가 실패한다.
    }
}
