package com.example.bcforum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bcforum.dto.UserCommentDto;
import com.example.bcforum.dto.UserDto;


public interface ForumOperation {
    @GetMapping("/users")
    List<UserDto> getUsers();

    @GetMapping("/users/{userID}/comments")
    UserCommentDto getUserComments(@PathVariable String userID);

    
}
