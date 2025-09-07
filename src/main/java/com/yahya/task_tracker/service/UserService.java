package com.yahya.task_tracker.service;

import com.yahya.task_tracker.entity.Task;
import com.yahya.task_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;



}
