package com.demo.forum.bc_forum.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.demo.forum.bc_forum.model.Post;
import main.java.com.demo.forum.bc_forum.model.User;
import main.java.com.demo.forum.bc_forum.service.JsonPlaceholderServiceImpl;

@RestController
@ResponseBody
// @RequestMapping("/new")
public class JsonPlaceholderController {
    // Get all comments by user id (Use RequestParam)
    // Each user may have zero or more posts, each post may have zero or more
    // comments.
    // If the user has no posts and no comments, return an empty list for
    // "comments".

    private final JsonPlaceholderServiceImpl jsonPlaceholderServiceImpl;
    private List<Post> posts; 
    private List<Comment> comments;
    private List<User> users;

    public JsonPlaceholderController(JsonPlaceholderServiceImpl jsonPlaceholderServiceImpl) {
        this.jsonPlaceholderServiceImpl = jsonPlaceholderServiceImpl;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        try {
            users = jsonPlaceholderServiceImpl.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlaceholderServiceImpl.getAllUsers();
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        try {
            posts = jsonPlaceholderServiceImpl.getAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlaceholderServiceImpl.getAllPosts();
    }

    // Get all comments by user id
    @GetMapping("/users/{userId}/comments")
    public List<Comment> getCommentsByUser(@PathVariable Long userId) {
        return jsonPlaceholderServiceImpl.getAllComments();
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return jsonPlaceholderServiceImpl.getAllPosts();
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return jsonPlaceholderServiceImpl.getAllComments();
    }

    @GetMapping(value = "/try")
    public String trytry() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "trytry";
    }

}
