package com.saugat.springsecuritydemo.controller;

import com.saugat.springsecuritydemo.model.User;
import com.saugat.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("user")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }
}
