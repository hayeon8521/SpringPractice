package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/")
    public String home() {
        return "users";  // `src/main/resources/templates/users.html`로 이동
    }
}
 