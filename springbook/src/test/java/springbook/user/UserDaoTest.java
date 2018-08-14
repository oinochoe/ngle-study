package springbook.user;

import org.springframework.context.support.GenericXmlApplicationContext;
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
        User user = new User("goyonam", "김영민", "springno1");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        /*User user = new User();
        user.setId("noel");
        user.setName("Yeongmin");
        user.setPassword("toby");*/

        dao.add(user);
        assertThat(dao.getCount(), is(1));

        User user2 = dao.get(user.getId());

        assertThat(user2.getId(), is(user.getId()));
        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

    }

    @Test
    public void count() throws SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("no1", "김영미니니", "spekek");
        User user2 = new User("no2", "김영미니니22", "spekek2");
        User user3 = new User("no3", "김영미니니33", "spekek33");

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

    public static void main(String[] args) {
        JUnitCore.main("springbook.user.UserDaoTest");
    }
}
