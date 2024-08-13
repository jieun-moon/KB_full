package org.scoula.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
//이 패키지 포함한 하위패키지 모두 다 조사
@ComponentScan({"org.scoula.todo"})

public class ProjectConfig {

    @Bean
    //구현체는 하나밖에 구현 못함
    Connection conn() throws Exception {
        Properties properties = new Properties();
        properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String id = properties.getProperty("id");
        String password = properties.getProperty("password");

        Class.forName(driver);
        return DriverManager.getConnection(url, id, password);
    }
}
