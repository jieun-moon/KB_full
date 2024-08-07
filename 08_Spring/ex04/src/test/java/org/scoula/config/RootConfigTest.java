package org.scoula.config;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class}) //테스트에서 사용할 설정 클래스
@Log4j
class RootConfigTest {

    @Autowired
    private DataSource dataSource;

    //Spring Context에서 sqlSessionFactory Bean을 주입받아옴
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    @DisplayName("DataSource 연결이 된다.")
    public void dataSource() throws SQLException {
        //getConnection: CP에서 conn 호출
        try(Connection con = dataSource.getConnection()) {
            log.info("DataSource 준비 완료");
            log.info(con);
            //con.close()에 반납
        }
    }

    @Test
    public void testSqlSessionFactory() {
        try(
                SqlSession session = sqlSessionFactory.openSession(); //sqlSessionFactory를 SqlSession로 open
                Connection con = session.getConnection(); //SqlSession로 Connection 연결
                ){
                    log.info(session);
                    log.info(con);

        } catch (Exception e) {
            //예외 발생 시 테스트 실패 처리
            fail(e.getMessage());
        }
    }

}