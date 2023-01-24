package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.Country;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper  implements RowMapper<Country> {

    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Country (rs.getString("countryName"),
                rs.getInt("countryId") );
    }
}
