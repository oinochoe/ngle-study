package springbook.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        //UserDao dao = new DaoFactory().userDao();
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();

        user.setId("Triumph");
        user.setName("김영민");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + "등록성공");

        User user2 = dao.get(user.getId());

        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회 성공");

        /*
        다른 객체가 생성된다.
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println(dao1);
        System.out.println(dao2);
        */

        /*
         * 스프링 컨텍스트로 가져오는 오브젝트는 출력값이 같다. 매번 new를 사용해서 새로운 객체가 만들어지지 않는다.
         *
         * UserDao dao3 = context.getBean("userDao", UserDao.class);
         * UserDao dao4 = context.getBean("userDao", UserDao.class);
         *
         * System.out.println(dao3);
         * System.out.println(dao4);
         */

    }
}
