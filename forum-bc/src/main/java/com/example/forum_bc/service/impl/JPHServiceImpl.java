package com.example.forum_bc.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.forum_bc.exception.BusinessException;
import com.example.forum_bc.exception.ErrorCode;
import com.example.forum_bc.model.dto.CommentDTO;
import com.example.forum_bc.model.dto.PostDTO;
import com.example.forum_bc.model.dto.UserDTO;
import com.example.forum_bc.service.JPHService;
import com.example.forum_bc.util.Scheme;
import com.example.forum_bc.util.Url;

@Service
public class JPHServiceImpl implements JPHService {

  private final String errorMsg = "RestTemplate Error - JsonPlaceHolder";

  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  @Override
  public List<UserDTO> getUsers() {
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.usersEndpoint) //
        .build() //
        .toUriString();
    try {
      return Arrays.asList(this.restTemplate.getForObject(url, UserDTO[].class));
    } catch (RestClientException e) {
      throw BusinessException.of(ErrorCode.REST_CLIENT_EX, this.errorMsg);
    }
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.postsEndpoint) //
        .build() //
        .toUriString();
    try {
      return Arrays.asList(this.restTemplate.getForObject(url, PostDTO[].class));
    } catch (RestClientException e) {
      throw BusinessException.of(ErrorCode.REST_CLIENT_EX, this.errorMsg);
    }
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.commentsEndpoint) //
        .build() //
        .toUriString();
    try {
      return Arrays.asList(this.restTemplate.getForObject(url, CommentDTO[].class));
    } catch (RestClientException e) {
      throw BusinessException.of(ErrorCode.REST_CLIENT_EX, this.errorMsg);
    }
  }
}
