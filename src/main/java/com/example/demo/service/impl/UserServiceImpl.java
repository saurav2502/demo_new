package com.example.demo.service.impl;

import com.example.demo.model.UserResource;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
    @Autowired
    private UserService userService;

    public List<UserResource> findUser() {
        return userService.findAll().stream().collect(Collectors.toList());
    }
}
