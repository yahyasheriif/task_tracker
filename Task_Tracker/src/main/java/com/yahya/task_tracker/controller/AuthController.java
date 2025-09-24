package com.yahya.task_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yahya.task_tracker.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        if ("yahya".equals(loginRequest.getUsername()) && "1234".equals(loginRequest.getPassword())) {
            return jwtUtil.generateToken(loginRequest.getUsername());
        } else {
            return "Invalid credentials";
        }
    }
}
