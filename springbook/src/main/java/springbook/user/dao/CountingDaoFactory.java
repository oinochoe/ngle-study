package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // application context 또는 bean factory가 사용할 설정정보라는 표시
public class CountingDaoFactory {

    @Bean // 오브젝트 생성을 담당하는 IOC용 메소드라는 표시
    public UserDao userDao() {
       // return new UserDao(connectionMaker());
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }
    // 모든 DAO는 여전히 connectionMaker() 에서 만들어지는 오브젝트를 DI 받는다.

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }
}
