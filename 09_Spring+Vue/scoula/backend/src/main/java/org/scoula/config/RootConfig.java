package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//"/": 1) url 상의 루트(webapp)
//어떤 경로에서 property를 가져올지 설정(classpath를 붙여줘야 프로젝트의 루트로 접근)
//그냥 /를 사용하면 webapp 폴더가 루트가 된다.
@PropertySource({"classpath:/application.properties"})
//MyBatis에게 알려줌.
//org.scoula.mapper: 여기에 등록되 Bean은 자동 등록. 자동 DI된다는 뜻
@MapperScan(basePackages = {"org.scoula.board.mapper"})
@ComponentScan(basePackages = {"org.scoula.board.service"})
@Slf4j
@EnableTransactionManagement //트랜잭션 관리 설정
public class RootConfig {
    //application.properties 파일에서 값을 읽어와서 변수에 주입
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    //아주 독특하게 동작
    //첫번째 호출됐을때 context 살펴봄 > 1) dataSource()라는 Bean이 등록됐는지 먼저 체크
    //첫번째 호출에 먼저 생성하고 등록
    //2) 또 호출되면, 있으면 거기에 있는 객체가 또 호출(메서드가 실행되는게 아님)
    //Singleton 패턴으로 운영됨
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        //설정 객체에 데이터베이스 연결 정보를 설정
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        //HikariDataSource 객체 생성 후 설정을 적용
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Autowired
    //applicationContext: application scope에 해당
    //servlet의 init에서 매개변수로 넘어옴
    ApplicationContext applicationContext;

    //MyBatis를 위한 것
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //myBatis 설정파일이 어디있느냐. Resource의 roote에 있다 알림
        sqlSessionFactory.setConfigLocation( //(중요)
                applicationContext.getResource("classpath:/mybatis-config.xml"));
        //Connection 풀이 뭐냐. dataSource() 준비.
        sqlSessionFactory.setDataSource(dataSource()); //(중요)
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

    //Transaction 처리를 누가 담당하게 할거냐
    @Bean
    public DataSourceTransactionManager transactionManager() {
        //dataSource()메서드 호출
        //dataSource()를 두번 호출하면, 두번 생성하는것 아닌가?
        //실제로는 아님
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }
}
