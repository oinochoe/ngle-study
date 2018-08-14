package springbook.user;

import springbook.user.domain.User;
import springbook.user.dao.UserDao;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("noel");
        user.setName("Yeongmin");
        user.setPassword("toby");

        dao.add(user);

        User user2 = dao.get(user.getId());

        assertThat(user2.getId(), is(user.getId()));
        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

    }

    public static void main(String[] args) {
        JUnitCore.main("springbook.user.UserDaoTest");
    }
}
