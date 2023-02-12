package com.example.tenderflex.controller;

import com.example.tenderflex.model.User;
import com.example.tenderflex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody @NonNull User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }
}
