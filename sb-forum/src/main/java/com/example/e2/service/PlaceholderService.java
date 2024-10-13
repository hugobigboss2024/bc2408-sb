package com.example.e2.service;

import java.util.List;

import com.example.e2.dto.Comments;
import com.example.e2.dto.Posts;
import com.example.e2.dto.User;

public interface PlaceholderService {
    List<User> getAllUsers();

    User getUserById(Long id);

    List<Posts> getAllPosts();

    Posts getPostById(Long postId);

    List<Posts> getPostsByUserId(Long userId);

    List<Comments> getAllComments();

    List<Comments> getCommentsByPostId(Long postId);

    List<Comments> getCommentsByUserId(Long userId);

}
