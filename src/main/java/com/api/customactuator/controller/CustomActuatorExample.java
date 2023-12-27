package com.api.customactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomActuatorExample {

    @GetMapping("/hello")
    public String printMessage(String message){
        return "Hello All!";
    }
    
}
