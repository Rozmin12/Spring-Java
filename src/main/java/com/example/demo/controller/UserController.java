package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
    return userService.registerNewUser(user);
    }
    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only accessible to Admin";
    }
    @GetMapping({"/forUser"})
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
