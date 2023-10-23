package com.example.springboot.tutorial.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
    public String helloWorld(){
        return welcomeMessage;
    }
}
