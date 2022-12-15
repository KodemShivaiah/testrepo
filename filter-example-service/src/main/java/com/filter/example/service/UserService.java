package com.filter.example.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviceUser123")
public class UserService {

    public String testUser(){
        return "Welcome to our application.";
    }

}
