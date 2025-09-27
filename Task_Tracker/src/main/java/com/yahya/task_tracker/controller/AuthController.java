package com.yahya.task_tracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yahya.task_tracker.entity.User;
import com.yahya.task_tracker.service.UserService;
import com.yahya.task_tracker.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Optional<User> curUser = userService.findByUsername(loginRequest.getUsername());
        if (curUser.isPresent()){
            User user = curUser.get();
            if (userService.passwordEncoder().matches(loginRequest.getPassword(), user.getPassword())) {
                return jwtUtil.generateToken(loginRequest.getUsername());
            } else {
                return "Invalid credentials";
            }
    }
        return null;}

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail());
    }
}
