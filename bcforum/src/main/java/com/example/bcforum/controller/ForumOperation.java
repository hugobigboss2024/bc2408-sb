package com.example.bcforum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.bcforum.dto.UserCommentDto;
import com.example.bcforum.dto.UserDto;
import com.example.bcforum.entity.CommentEntity;
import com.example.bcforum.entity.PostsEntity;
import com.example.bcforum.entity.UsersEntity;


public interface ForumOperation {
    @GetMapping("/users")
    List<UserDto> getUsers();

    @GetMapping("/users/{userID}/comments")
    UserCommentDto getUserComments(@PathVariable String userID);

    @GetMapping("/allusers")
    List<UsersEntity> getAllUsers();

    @GetMapping("/users/{id}")
    UsersEntity getUserById(Long id);

    @PutMapping("/users/{id}")
    Boolean ReplaceExistingUser(Long id, UsersEntity user);

    @GetMapping("/allposts")
    List<PostsEntity> getAllPosts();

    @GetMapping("/posts/{id}")
    PostsEntity getPostById(Long id);

    @PostMapping("/posts/{id}")
    Boolean AddNewPost(Long id);

    @DeleteMapping("/posts/{id}")
    Boolean DeletePost(Long id);

    @GetMapping("/allcomments")
    List<CommentEntity> getAllComments();

    @GetMapping("/comments/{id}")
    CommentEntity getCommentById(Long id);

    @PostMapping("/comments/{id}")
    Boolean AddNewComment(Long id);

    @DeleteMapping("/comments/{id}")
    Boolean DeleteComment(Long id);
    
}
