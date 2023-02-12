package com.example.tenderflex.repository.mapper;
import com.example.tenderflex.model.CPV;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CPVMapper implements RowMapper<CPV> {
    public CPV mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CPV (rs.getString("CPV_name") ,
        rs.getInt("CPV_id") );

    }
}
