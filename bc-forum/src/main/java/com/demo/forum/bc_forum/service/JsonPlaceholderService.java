package com.demo.forum.bc_forum.service;

import java.util.List;

import com.demo.forum.bc_forum.model.Comment;
import com.demo.forum.bc_forum.model.Post;
import com.demo.forum.bc_forum.model.User;

public interface JsonPlaceholderService {
    List<User> getAllUsers();

    List<Post> getAllPosts();

    List<Comment> getAllComments();

}
