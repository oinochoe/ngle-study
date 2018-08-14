package springbook.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("Triumph");
        user.setName("김영민");
        user.setPassword("married");

        dao.add(user);

        User user2 = dao.get(user.getId());

        if (!user.getId().equals(user2.getId())) {
            System.out.println("테스트 실패 (Id)");
        } else if (!user.getPassword().equals(user2.getPassword())) {
            System.out.println("테스트 실패 (Password)");
        } else if (!user.getName().equals(user2.getName())) {
            System.out.println("테스트 실패 (Name)");
        } else {
            System.out.println("조회테스트 성공");
        }

    }
}
