package com.example.tenderflex.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class UserController {

    @GetMapping
    public String checkUser() {

        return "Test";
    }

}
