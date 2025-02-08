package com.example.product_service.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/isAlive")
    public String isAlive() {
        return "I'am alive";
    }
}
