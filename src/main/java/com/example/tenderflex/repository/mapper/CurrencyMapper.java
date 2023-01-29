package com.example.tenderflex.repository.mapper;


import com.example.tenderflex.model.Currency;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyMapper implements RowMapper<Currency> {
    public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Currency (rs.getString("currency_name"),
                rs.getInt("currency_id") );
    }


}
