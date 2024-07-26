package org.example;

import org.example.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
            String id = "jdbc_ex";
            String password = "jdbc_ex";
            Connection conn = JDBCUtil.getConnection();

            System.out.println("DB 연결 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close();
        }
    }
}
