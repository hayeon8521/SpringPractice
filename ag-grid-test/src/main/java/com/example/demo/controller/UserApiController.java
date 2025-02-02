package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @GetMapping("/users")
    public List<User> getUsers() {
        return Arrays.asList(
            new User("Tesla", "Model K", 7777, true),
            new User("Ford", "H-Series", 8888, false),
            new User("Toyota", "Horolla", 9999, false)
        );
    }
}
