package com.example.tenderflex.service;

import com.example.tenderflex.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void saveUser(User user);
}
