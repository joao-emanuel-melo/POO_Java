package com.example.demo.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @GetMapping("/AllUsers")
    public List <UserModel> getAllUsers() {
        return userService.getAll();
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }
    
}
