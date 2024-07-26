package org.example;

import org.example.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserTest {
    public static void main(String[] args) {
        String sql = "insert into users(id, password, name, role) values(?, ?, ?, ?)";

        try(Connection conn = JDBCUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();

            System.out.println(count+"건 데이터 처리 성공!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
