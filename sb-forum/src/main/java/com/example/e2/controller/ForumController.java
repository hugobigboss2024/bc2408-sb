package com.example.e2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e2.dto.Comments;
import com.example.e2.dto.Company;
import com.example.e2.dto.Posts;
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

    @GetMapping("/posts")
    public List<Posts> getPosts() {
        return placeholderService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public Posts getPostById(@PathVariable Long postId) {
        return placeholderService.getPostById(postId);
    }

    @GetMapping("/users/{userId}/posts")
    public List<Posts> getPostsByUserId(@PathVariable Long userId) {
        return placeholderService.getPostsByUserId(userId);
    }

    @GetMapping("/comments")
    public List<Comments> getComments() {
        return placeholderService.getAllComments();
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comments> getCommentsByPostId(@PathVariable Long postId) {
        return placeholderService.getCommentsByPostId(postId);
    }

    @GetMapping("/users/{userId}/comments")
    public List<Comments> getCommentsByUserId(@PathVariable Long userId) {
        return placeholderService.getCommentsByUserId(userId);
    }

    @GetMapping("/users/{userID}/company")
    public Company getCompanyByUserId(@PathVariable Long userID) {
        return placeholderService.getCompanyByUserId(userID);
    }

}
