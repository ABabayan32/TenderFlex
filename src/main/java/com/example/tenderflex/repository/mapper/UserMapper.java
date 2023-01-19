package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.User;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getLong("id"),
                rs.getString("User_name"),
                rs.getString("password"),
                null);
    }
}
