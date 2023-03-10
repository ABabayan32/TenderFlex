package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Role(rs.getLong("role_id"),
                rs.getString("role_name")
                );
    }
}
