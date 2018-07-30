# 메모

1. MYSQLConnectionTest 작성 시 pom.xml 상에 mysql dependency 버전 변경을 최신으로 변경해주십시오.
2. MariaDB를 사용해서 작업했습니다.
3. 3Tier에 대해서
	* Presentation Layer - UI를 담당하는 구성요소
	* Business Layer - 서비스 계층, 비지니스 계층은 어떤 형태의 데이터가 필요하고 반환될지 결정
	* Data Access Layer - Persistence Layer , 데이터 처리를 담당

4. Mybatis를 쓰는 이유
	* 간결한 코드 처리 - Mapper를 사용해서 간결하게 작성할 수 있다.
	* SQL문의 분리운영 - 많은 양의 SQL에 대해서는 별도의 XML을 작업하는 형태로 간결함 유지
	* Spring과의 연동으로 자동화된 처리 - Mybatis-Spring이라는 라이브러리가 클래스를 자동으로 만들어줌
	* 동적 SQL을 이용한 제어 기능 - 제어문 루프 등의 처리 기능이 있습니다. SQL 관련 된 처리를 JAVA 코드에서 분리 가능

5. 웹과 관련된 설정은 servlet-context.xml로 관련하고 나머지는 web-inf/wpring/root-context.xml에서 처리

6. mysql과 연결을 하는 DataSource 설정하기.
	* @RunWith, @ContextConfiguration 어노테이션은 현재 테스트 코드를 실행할 때 스프링이 로딩 되도록 하는 부분
	* @ContextConfiguration의 locations 속성 경로에 xml파일을 이용해서 스프링이 로딩된다.
	* 인스턴스 변수의 @Inject 어노테이션 처리된 DatSource는 스프링이 생성해 주입합니다. IOC..
	
7. root-context.xml 작성시
	* Invocation of destroy method 'close' failed on bean with name 'sqlSessionTemplate'
		* destroy-method="clearCache"를 bean 설정에 추가해야한다.
	* property name에보면 configLocation과 mapperLocation이 있는데 configLocation은 		
	  mybatis-cofing.xml 파ㅇ일의 경로고 mapperLocation은  mapper의 경로이다.
	  http://clairdelunes.tistory.com/11
	* 상단 링크에서 logback xml 설정도 확인해서 설정해본다.
	* mysql connection 버전 관련 오류 
	- http://developer-kylee.tistory.com/8
	- http://blog.naver.com/PostView.nhn?blogId=nateen7248&logNo=220819210032&parentCategoryNo=&categoryNo=58&viewDate=&isShowPopularPosts=false&from=postView
	
8. mybatis
	* mybatis의 핵심은 Connection 생성, 처리하는 SqlSessionFactory..(DB와 연결, SQL 실행에 대한 모든 것)
	* mybatis config dtd로 꼭 mybatis-config.xml을 설정해준다..
	* mybatis-config.xml이 스프링이 동작할 때 작동할 수 있도록 root-context.xml 수정합니다.
	
9. MVC
	* Spring MVC
		* URI 분석, 적절한 컨트롤러 찾음
		* 컨트롤러에 필요한 메서드 호출
		* 컨트롤러의 결과 데이터를 뷰로 전달
		* 적절한 뷰 찾기
	* 개발자가 직접 해야하는 작업
		* 특정 URI에 동작하는 컨트롤러를 설계
		* 서비스 객체 생성
		* DAO 객체 생성
		* 컨트롤러 내에 원하는 결과를 메소드로 설계
		* 뷰에서 전달받은 데이터의 출력
	* appServlet 폴더 내에 존재하는 servlet-context.xml은 스프링 MVC 관련 설정만을 분리하기 위해 만들어진 파

10. addAttribute의 두가지 형태
	* addAttribute("이름", 객체) : 객체이 특별한 이름을 부여해서 뷰에 이름값을 이용하여 객체처리
	* addAttribute(객체) : 이름을 지정하지 않는 경우에는 자동으로 저장되는 객체의 클래스명 앞글자를 소문자로 처리한 클래스명을 이름으로 간주.
	* addFlashattribute : 임시정보 전달....
	
11. WAS 없이 컨트롤러 테스트 하기
	* 스프링 MVC가 특별하게 느껴지는 이유 중 하나는 spring-test 모듈을 통해 별도의 WAS 구동 없이도 컨트롤러를 테스트하는 작업이 가능하기 때문이다.
	* 컨트롤러의 테스트 코드 작성은 test 폴더를 이용해서 작업, was를 실행하지 않고 컨트롤러 테스트하기 위해서는 pom.xml의 servlet 버전을 업해줘야 가능.

12. import org.springframework.test.context.web.WebAppConfiguration;
	* @WebAppConfiguration 어노테이션이 기존 스프링과 MVC 테스트하는 데 있어 가장 큰 차이입니다.
	
13. 테스트를 해서 개발하는 것의 이점
	* 웹페이지 테스트 하려 할때 매번 입력하고 확인하는데 시간 소요가 깁니다.
	* WAS에 만들어진 컨트롤러 코드를 새로 수정하고 배포하는 작업은 많은 시간 소요
	* 컨트롤러에서 결과 데이터만 확인할 수 있기 때문에 원인 파악이 쉬움. 

14. 스프링 + Mybatis
	* mybatis는 JDBC에서 개발자가 직접 처리하는 PreparedStatement의 '?'에 대한 설정이나 ResultSet을 이용한 처리가 이루어지기 때문에 기존 방식에 비해 
	    개발 생산성이 좋아집니다.
	* 기존 iBatis는 개발자가 모든 SQL을 XML로 작성, SQL문을 사용하는 DAO 클래스를 설계해서 SQL문을 호출하는 방식의 코드 작성
	* 여기서 더 발전된 형태인 MyBatis는 어노테이션 지원, 인터페이스와 어노테이션을 통한 SQL문을 설정, 처리 할 수 있는 형태로 발전
	
15. MyBati 이용할 때 SQL문 사용하는 방식
	* XML만을 이용해서 SQL문을 설정, DAO에서는 XML을 찾아서 실행하는 코드를 작성하는 방식
		* 장점 : SQL문은 별도의 XML로 작성되기 때문에 SQL 문의 수정이나 유지보수에 적합
		* 단점 : 개발 시 코드 양이 많아지고 복잡성이 증가.
	* 어노테이션과 인터페이스만을 이용해서 SQL 문을 설정
		* 장점 : 별도의 DAO 없이도 개발이 가능, 생산성 증가
		* 단점 : SQL문을 어노테이션 작성, 매번 수정이 일어나는 경우 다시 컴파일
	* 인터페이스와 XML로 작성된 SQL문의 활용
		* 장점 : 간단한 SQL문을 어노테이션으로, 복잡한 SQL문은 XML로 처리하므로, 상황에 따른 유연성
		* 단점 : 개발자에 따라 개발 방식 차이, 유지보수 프로젝트에 부적합
	* 주로  첫번째 방법을 선호합니다. 유지보수 때문...
	
16. 테이블명은 일반적으로 'tbl_' prefix를 선호합니다.
		
17. XML Mapper를 작성할 때는 'namespace'라는 설정에 가장 신경을 많이 써야만 합니다.
18. 'namespace' 속성은 클래스 패키지와 유사한 용도로 Mybatis 내에서 원하는 SQL문을 찾아서 실행할 때 동작합니다.
19. Mybatis에서 DAO를 이용하는 경우는 SqlSessionTemplate이라는 것을 이용해서 DAO를 구현합니다.
20. DAO의 작업중에 가장 중요하고 번거로운 작업은 데이터베이스와 연결을맺고 작업이 완료되면 close로 연결을 끊는 작업입니다.
21. SqlSessionTemplate SqlSession 인터페이스를 구현한 클래스로 기본적인 트랜잭션의 관리나 쓰레드의 처리의 안정성등을 보장해주고, 
	데이터베이스의 연결과 종료를 책임집니다. SqlSessionFactory를 생성자로 주입해서 설정합니다.

22. @Repository는 DAO를 스프링에 인식시키기 위해서 주로 사용합니다.

23. Mybatis Sql 처리문
	* <T> selectOne(String statement, Object parameter)
	* <E> List<E> selectList(String statement, Object parameter)
	* <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey)
	* int insert(String statement, Object parameter)
	* int update(String statement, Object parameter)
	* int delete(String statement, Object parameter)
	

24. log4j 를 사용했다(log error를 잡기위해서)
	* 책 내용을 보다가 안되면 아래에 참고.. 책에서 되면 상관없다.
	* https://appear.github.io/2017/12/14/Spring/spring-01/
	


# 주의사항

* Pom.xml 작성시 1.6이라고 되어있는 JAVA 버전 업그레이드 시 같이 maven compiler 버전도 올려줘야합니다.

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>2.5.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <compilerArgument>-Xlint:all</compilerArgument>
        <showWarnings>true</showWarnings>
        <showDeprecation>true</showDeprecation>
    </configuration>
</plugin>