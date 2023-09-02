package com.oliver.Registrationform.controller;

import com.oliver.Registrationform.model.User;
import com.oliver.Registrationform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/home")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

//    @GetMapping("/register")
//    public String getRegister() {
//        return "register";
//    }
//
//    @GetMapping("/login")
//    public String getLogin() {
//        return "login";
//    }

//    @GetMapping("/success")
//    public String getSuccess() {
//        return "success";
//    }

//    @GetMapping("/fail")
//    public String getFail() {
//        return "fail";
//    }

//    @PostMapping("/register")
//    public String register(User user) {
//        int savedUser = userRepository.saveUser(user);
//        if (savedUser > 0) {
//            return "redirect:/success";
//        } else {
//            return "redirect:/fail";
//        }
//    }
//
//    @PostMapping("/login")
//    public String login(User user) {
//        int foundUser = userRepository.findUser(user);
//        if (foundUser > 0) {
//            return "redirect:/success";
//        } else {
//            return "redirect:/fail";
//        }
//    }
}
