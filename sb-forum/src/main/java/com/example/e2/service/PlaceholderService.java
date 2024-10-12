package com.example.e2.service;

import java.util.List;

import com.example.e2.dto.Comments;
import com.example.e2.dto.Posts;
import com.example.e2.dto.User;

public interface PlaceholderService {
    List<User> getUsers();

    List<Posts> getPosts();

    List<Comments> getAllComments();

    List<Comments> getCommentsByPostId(int postId);

}
