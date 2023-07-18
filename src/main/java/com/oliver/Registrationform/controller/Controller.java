package com.oliver.Registrationform.controller;

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

    @GetMapping("/success")
    public String getSuccess() {
        return "success";
    }

    @GetMapping("/fail")
    public String getFail() {
        return "fail";
    }

    @PostMapping("/register")
    public String register(
//            @Valid User user
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        int rowsAffected = jdbcTemplate.update(sql, username, email, password);

        if (rowsAffected > 0) {
            return "redirect:/success";
        } else {
            return "redirect:/fail";
        }
    }
}
