package com.example.web_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping (value="/")
    public String hello() {
        return "hello hello";
    }
}

