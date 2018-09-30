package com.mybatis.board;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//MapperScan : Mapper 인터페이스를 인식할 수 있도록 설정
@MapperScan(value={"com.mybatis.board.mapper"})
public class MybatisApplication {
	
	//스프링 부트는 별도의 서버 설정 없이 main() 메서드를 실행하는것 만으로도 내장된 Tomcat서버를 이용해서 프로젝트가 실행됩니다.
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}


	 /*
     * SqlSessionFactory 설정 
     */
	
    @Bean //스프링에 필요한 객체를 생성한다.
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
    	
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        //sqlSessionFactory() : MyBatis의 SqlSessionFactory를 반환해줍니다. 
        //스프링부트가 실행할 때 DataSource객체를 이 메서드 실행 시 주입해서 결과를 만들고,
        //그 결과를 스프링내 빈으로 사용하게 됩니다. 
        
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();        
    }
}


