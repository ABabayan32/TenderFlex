package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.User;
import com.example.tenderflex.repository.UserRepository;
import com.example.tenderflex.repository.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> users =  this.jdbcTemplate.query("SELECT * FROM tender_flex.User INNER JOIN tender_flex.role ON tender_flex.user.role_id = tender_flex.role.role_id WHERE \"User_name\" = ?;", new UserMapper(), username);
        if (users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update("insert into tender_flex.User(\"User_name\", \"password\", \"role_id\") values (?, ?, ?)",
                user.getUsername(), user.getPassword(), null);
    }
}
