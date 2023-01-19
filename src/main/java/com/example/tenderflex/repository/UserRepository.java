package com.example.tenderflex.repository;

import com.example.tenderflex.model.User;

public interface UserRepository {
    User getUserByUsername(String username);
    void saveUser(User user);
}
