package com.example.port.controller;

import com.example.port.model.User;
import com.example.port.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Hash password ในจริงควรใช้ BCrypt!
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User login) {
        User user = userRepository.findByEmail(login.getEmail());
        if (user != null && user.getPassword().equals(login.getPassword())) {
            return user; // จริงควร return JWT token
        }
        return null;
    }
}
