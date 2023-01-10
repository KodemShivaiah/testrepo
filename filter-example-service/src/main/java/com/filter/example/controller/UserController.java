package com.filter.example.controller;

import com.filter.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    @Qualifier("userService123")
    private UserService userService;

    @GetMapping
    public String printUserName(@RequestParam("username") String username){
        return "Hello, Mr./Miss. "+username+" welcome to our application";
    }

    @GetMapping("/data")
    public List<String> getListOfStrings(){
        List<String> data = Arrays.asList(new String[]{"Shiva", "Naresh", "Sai", "Papa"});
        return data;
    }

}
