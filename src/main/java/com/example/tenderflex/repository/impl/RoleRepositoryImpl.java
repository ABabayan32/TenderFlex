package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.Role;
import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.RoleRepository;
import com.example.tenderflex.repository.mapper.RoleMapper;
import com.example.tenderflex.repository.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.http.HttpHeaders.FROM;

@Repository
public class RoleRepositoryImpl implements RoleRepository {


    private final JdbcTemplate jdbcTemplate;

    public RoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role getRoleById(Long id) {
        List<Role> role = jdbcTemplate.query("SELECT * FROM tender_flex.role WHERE \"role_id\" = ?", new RoleMapper(), id);
        if (role.isEmpty()) {
            return null;
        }
        return role.get(0);
    }

    public List<Role> getAllRoles() {
        List<Role> roles = jdbcTemplate.query("SELECT * FROM tender_flex.role", new RoleMapper());
        return roles;
    }
}