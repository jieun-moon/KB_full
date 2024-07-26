package org.example;

import org.example.common.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUserTest {
    public static void main(String[] args) {
        String sql = "select * from users";

        try(Connection conn = JDBCUtil.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
