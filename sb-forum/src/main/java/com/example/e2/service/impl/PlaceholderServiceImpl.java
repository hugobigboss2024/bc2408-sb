package com.example.e2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.e2.dto.Comments;
import com.example.e2.dto.Posts;
import com.example.e2.dto.User;
import com.example.e2.service.PlaceholderService;

@Service
public class PlaceholderServiceImpl implements PlaceholderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getAllUsers() {

    }

    @Override
    public User getUserById(Long id) {

    }

    @Override
    public List<Posts> getAllPosts() {

    }

    @Override
    public Posts getPostById(Long postId) {

    }

    @Override
    public List<Posts> getPostsByUserId(Long userId) {

    }

    @Override
    public List<Comments> getAllComments() {

    }

    @Override
    public List<Comments> getCommentsByPostId(Long postId) {

    }

    @Override
    public List<Comments> getCommentsByUserId(Long userId) {

    }

}