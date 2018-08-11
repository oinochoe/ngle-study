package springbook.user.dao;

import springbook.user.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker; // 인터페이슬 통해 정보에 접근, 구체적인 클래스 정보 알 필요 없다

    //public UserDao(ConnectionMaker connectionMaker) {
        // 의존관계 검색을 이용하는 UserDao 생성자
        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);*/
        /* 사용자에 대한 DB정보를 어떻게 가져올 것인가에 집중해야하는 DAO(Data Access Object) 에서
         * 스프링이나 오브젝트 팩토리를 만들고 API를 이용하는 코드가 섞여있는 것은 어색하다.
         */


        // 의존관계 주입을 이용하는 UserDao 생성자
        //this.connectionMaker = connectionMaker;

        // 의존관계 주입쪽이 훨씬 깔끔하다.
    //}

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into tbl_users(id, name, password) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from tbl_users where id = ?");

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }



}
