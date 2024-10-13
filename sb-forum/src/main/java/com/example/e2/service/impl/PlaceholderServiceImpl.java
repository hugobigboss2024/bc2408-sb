package com.example.e2.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.e2.dto.Comments;
import com.example.e2.dto.Company;
import com.example.e2.dto.Posts;
import com.example.e2.dto.User;
import com.example.e2.service.PlaceholderService;

@Service
public class PlaceholderServiceImpl implements PlaceholderService {

    @Autowired
    @Qualifier(value = "PlanceholderRestTemplate")
    private RestTemplate restTemplate;

    @Value("${placeholder.base-url}")
    private String baseUrl;

    @Override
    public List<User> getAllUsers() {
        User[] users = restTemplate.getForObject(baseUrl + "/users", User[].class);
        return users != null ? Arrays.asList(users) : Collections.emptyList();

    }

    @Override
    public User getUserById(Long id) {
        return restTemplate.getForObject(baseUrl + "/users/" + id, User.class);

    }

    @Override
    public List<Posts> getAllPosts() {
        Posts[] posts = restTemplate.getForObject(baseUrl + "/posts", Posts[].class);
        return posts != null ? Arrays.asList(posts) : Collections.emptyList();

    }

    @Override
    public Posts getPostById(Long postId) {
        return restTemplate.getForObject(baseUrl + "/posts/" + postId, Posts.class);

    }

    @Override
    public List<Posts> getPostsByUserId(Long userId) {
        Posts[] posts = restTemplate.getForObject(baseUrl + "/users/" + userId + "/posts", Posts[].class);
        return posts != null ? Arrays.asList(posts) : Collections.emptyList();

    }

    @Override
    public List<Comments> getAllComments() {
        Comments[] comments = restTemplate.getForObject(baseUrl + "/comments", Comments[].class);
        return comments != null ? Arrays.asList(comments) : Collections.emptyList();

    }

    @Override
    public List<Comments> getCommentsByPostId(Long postId) {
        Comments[] comments = restTemplate.getForObject(baseUrl + "/posts/" + postId + "/comments", Comments[].class);
        return comments != null ? Arrays.asList(comments) : Collections.emptyList();

    }

    @Override
    public List<Comments> getCommentsByUserId(Long userId) {
        Comments[] comments = restTemplate.getForObject(baseUrl + "/users/" + userId + "/comments", Comments[].class);
        return comments != null ? Arrays.asList(comments) : Collections.emptyList();

    }

    @Override
    public Company getCompanyByUserId(Long userID) {
        return restTemplate.getForObject(baseUrl + "/users/" + userID + "/company", Company.class);

    }

}