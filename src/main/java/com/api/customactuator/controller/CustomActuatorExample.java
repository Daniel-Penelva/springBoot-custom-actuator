package com.api.customactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomActuatorExample {

    // http://localhost:8080/hello
    // http://localhost:8080/actuator
    // http://localhost:8080/actuator/info
    @GetMapping("/hello")
    public String printMessage(String message){
        return "Hello All!";
    }
    
}
