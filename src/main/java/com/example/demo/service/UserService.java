package com.example.demo.service;

import com.example.demo.model.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public interface UserService extends JpaRepository<UserResource,Integer>{
}
