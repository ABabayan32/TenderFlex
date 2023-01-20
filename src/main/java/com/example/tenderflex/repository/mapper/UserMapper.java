package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.Role;
import com.example.tenderflex.model.User;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = null;
        if(rs.getObject("role_id") != null){
           role = new Role(rs.getLong("role_id"), rs.getString("role_name"));
        }
        return new User(rs.getLong("id"),
                rs.getString("password"),
                rs.getString("User_name"),
                role);
    }
}
