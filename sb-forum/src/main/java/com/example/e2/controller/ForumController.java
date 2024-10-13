package com.example.e2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e2.dto.User;
import com.example.e2.service.PlaceholderService;

@RestController
@RequestMapping("/api")
public class ForumController {
    private final PlaceholderService placeholderService;

    public ForumController(PlaceholderService placeholderService) {
        this.placeholderService = placeholderService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return placeholderService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return placeholderService.getUserById(userId);

    }

}
