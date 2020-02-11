package com.example.demo.controller;

import com.example.demo.model.UserResource;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/finUserByDepatment")
    public List<UserResource>finUserByDepatment(){
        List<UserResource>users = new ArrayList<>();
        users = userService.findAll();
        if (0 == users.size()){
            UserResource userResource = new UserResource();
            userResource.setName("Saurav");
            users.add(userResource);
        }
        return users;
    }
}
