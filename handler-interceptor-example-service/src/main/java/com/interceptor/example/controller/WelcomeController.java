package com.interceptor.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    @GetMapping
    public String welcomeMsg(@RequestParam("username") String username){
        System.out.println("hgj jhg jg jhg jgh j");
        return "Hello, Mr./Miss. "+username+ " welcome to our application.";
    }


}
