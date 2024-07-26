package org.example.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    static Connection conn = null;
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
            String id = "jdbc_ex";
            String password = "jdbc_ex";
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        try{
            if(conn != null){
                conn.close();
                conn = null;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
