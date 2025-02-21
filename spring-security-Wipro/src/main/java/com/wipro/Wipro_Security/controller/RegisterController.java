package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Userinfo;
import com.wipro.Wipro_Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Userinfo createUser(@RequestBody Userinfo user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @GetMapping("/users")
    public List<Userinfo> getAllUsers() {
        return repo.findAll();
    }
}
