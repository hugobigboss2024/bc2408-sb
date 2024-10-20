package com.example.bcforum.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.bcforum.exception.AllExceptions;
import com.example.bcforum.exception.ErrorCode;
import com.example.bcforum.model.dto.CommentDTO;
import com.example.bcforum.model.dto.PostDTO;
import com.example.bcforum.model.dto.UserDTO;
import com.example.bcforum.service.ForumService;
import com.example.bcforum.util.Scheme;
import com.example.bcforum.util.Url;

@Service
public class ForumServiceImpl implements ForumService {

    private final String errorMessage = "Error RestTemplate - ???";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.jph.domain}")
    private String jphDomain;
    @Value("${api.jph.users.endpoint}")
    private String usersEndpoint;
    @Value("${api.jph.posts.endpoint}")
    private String postsEndpoint;
    @Value("${api.jph.comments.endpoint}")
    private String commentsEndpoint;

    @Override
    public List<UserDTO> getUsers() {
        String url = Url.builder().scheme(Scheme.HTTPS).domain(this.jphDomain).endpoint(this.usersEndpoint).build()
                .toUriString();
        try {
            return Arrays.asList(restTemplate.getForObject(url, UserDTO[].class));
        } catch (RestClientException e) {
            throw AllExceptions.of(ErrorCode.REST_CLIENT_EX, e.getMessage());
        }
    }

    @Override
    public List<PostDTO> getPosts() {
        String url = Url.builder().scheme(Scheme.HTTPS).domain(this.jphDomain).endpoint(this.postsEndpoint).build()
                .toUriString();
        try {
            return Arrays.asList(restTemplate.getForObject(url, PostDTO[].class));
        } catch (RestClientException e) {
            throw AllExceptions.of(ErrorCode.REST_CLIENT_EX, this.errorMessage);
        }
    }

    @Override
    public List<CommentDTO> getComment() {
        String url = Url.builder().scheme(Scheme.HTTPS).domain(this.jphDomain).endpoint(this.commentsEndpoint).build()
                .toUriString();
        try {
            return Arrays.asList(restTemplate.getForObject(url, CommentDTO[].class));
        } catch (RestClientException e) {
            throw AllExceptions.of(ErrorCode.REST_CLIENT_EX, this.errorMessage);
        }
    }

}
