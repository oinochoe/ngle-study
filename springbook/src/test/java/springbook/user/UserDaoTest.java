package springbook.user;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

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

    @Test
    public void getAll() throws SQLException {
        dao.deleteAll();

        List<User> users0 = dao.getAll();
        assertThat(users0.size(), is(0)); // 데이터가 없을 때는 크기가 0인 리스트 오브젝트가 리턴되야함.

        dao.add(user1); //ID : yeongmin
        List<User> users1 = dao.getAll();
        assertThat(users1.size(), is(1));
        checkSameUser(user1, users1.get(0));

        dao.add(user2); //ID : yeongmin2
        List<User> users2 = dao.getAll();
        assertThat(users2.size(), is(2));
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));

        dao.add(user3); //ID : yeongmin3
        List<User> users3 = dao.getAll();
        assertThat(users3.size(), is(3));
        checkSameUser(user1, users3.get(0));
        checkSameUser(user2, users3.get(1));
        checkSameUser(user3, users3.get(2));
    }

    private void checkSameUser(User user1, User user2) {
        // User 오브젝트의 내용을 비교하는 검증 코드. 테스트에서 반복적으로 사용되므로 분리함.
        assertThat(user1.getId(), is(user2.getId()));
        assertThat(user1.getName(), is(user2.getName()));
        assertThat(user1.getPassword(), is(user2.getPassword()));
    }
}
