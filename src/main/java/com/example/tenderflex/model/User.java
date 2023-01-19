package com.example.tenderflex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;

    private String password;
    private String username;
    private Role role;
}
