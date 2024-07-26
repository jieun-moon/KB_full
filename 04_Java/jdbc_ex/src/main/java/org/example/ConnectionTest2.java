package org.example;

import org.example.common.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest2 {
    public static void main(String[] args) {
        try(Connection conn = JDBCUtil.getConnection()){
            System.out.println("DB 연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
