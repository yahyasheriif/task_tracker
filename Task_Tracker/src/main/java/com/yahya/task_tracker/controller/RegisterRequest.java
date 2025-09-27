package com.yahya.task_tracker.controller;

import lombok.Data;
@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
}
