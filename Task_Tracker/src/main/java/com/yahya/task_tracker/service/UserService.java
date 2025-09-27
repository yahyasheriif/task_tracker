package com.yahya.task_tracker.service;

import com.yahya.task_tracker.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.yahya.task_tracker.entity.User;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String registerUser(String username, String password, String email) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already exists";
        }
        userRepository.save(new User(username, passwordEncoder().encode(password), email));
        System.out.println(passwordEncoder().encode(password));
        return "User registered successfully";
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
