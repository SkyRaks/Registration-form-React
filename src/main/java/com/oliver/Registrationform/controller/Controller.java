package com.oliver.Registrationform.controller;

import com.oliver.Registrationform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Controller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
//            @RequestBody User user
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email
    ) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, username, email, password);

        if (rowsAffected > 0) {
            return "Registration successful!";
        } else {
            return "Registration failed!";
        }
    }
}
