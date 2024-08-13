package org.scoula.todo.travel.dao;

import org.scoula.todo.travel.domain.TravelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class TravelDaoImpl implements TravelDao{
    @Autowired
    Connection conn;

    @Override
    void create(TravelVO travel) throws SQLException {
        String sql = "insert into travel values(?,?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, travel.getNo());
            ps.setString(2, travel.getDistrict());
            ps.setString(3, travel.getTitle());
            ps.setString(4, travel.getDescription());
            ps.setString(5, travel.getAddress());
            ps.setString(6, travel.getPhone());
            ps.executeUpdate();
        }
    }
}
