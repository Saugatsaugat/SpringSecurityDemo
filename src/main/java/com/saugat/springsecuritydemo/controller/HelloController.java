package com.saugat.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("ping")
    public String ping(){
        return "Hello from Hello Controller";
    }
}
