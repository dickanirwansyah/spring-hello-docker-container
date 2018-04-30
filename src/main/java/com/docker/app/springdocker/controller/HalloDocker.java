package com.docker.app.springdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloDocker {

    @GetMapping(value = "/hello")
    public String getGreetingDocker(){
        return "Hallo Spring boot & Docker Container";
    }
}
