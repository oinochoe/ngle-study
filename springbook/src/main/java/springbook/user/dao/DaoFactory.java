package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // application context 또는 bean factory가 사용할 설정정보라는 표시
public class DaoFactory {

    @Bean // 오브젝트 생성을 담당하는 IOC용 메소드라는 표시
    public UserDao userDao() {
        // 수정자 형태로 바꿈
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
        //return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
