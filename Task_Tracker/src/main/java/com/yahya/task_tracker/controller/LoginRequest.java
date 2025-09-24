package com.yahya.task_tracker.controller;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
