package com.demo.forum.bc_forum.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.forum.bc_forum.model.Comment;
import com.demo.forum.bc_forum.model.Post;
import com.demo.forum.bc_forum.model.User;

@Service
public class JsonPlaceholderServiceImpl implements JsonPlaceholderService {
    @Autowired
    @Qualifier(value = "JrestTemplate")
    private RestTemplate restTemplate;

    @Value("${api.jph.domain}")
    private String JDomain;

    @Value("${api.jph.endpoint.user}")
    private String JUser;

    /*
     * public JsonPlaceholderServiceImpl(RestTemplate restTemplate) {
     * this.restTemplate = restTemplate;
     * }
     */

    @Override
    public List<User> getAllUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        User[] users = restTemplate.getForObject(url, User[].class);
        return Arrays.asList(users);
    }

    @Override
    public List<Post> getAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Post[] posts = restTemplate.getForObject(url, Post[].class);
        return List.of(posts);
    }

    @Override
    public List<Comment> getAllComments() {
        String url = "https://jsonplaceholder.typicode.com/comments";
        Comment[] comments = restTemplate.getForObject(url, Comment[].class);
        return Arrays.asList(comments);
    }
}
