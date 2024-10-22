package com.example.bcforum.service;

import java.util.List;

import com.example.bcforum.entity.CommentEntity;
import com.example.bcforum.entity.PostsEntity;
import com.example.bcforum.entity.UsersEntity;
import com.example.bcforum.model.dto.CommentDTO;
import com.example.bcforum.model.dto.PostDTO;
import com.example.bcforum.model.dto.UserDTO;

public interface ForumService {
    List<UserDTO> getUsers();

    List<PostDTO> getPosts();

    List<CommentDTO> getComments();

    /////////////////////////////////
    List<UsersEntity> getUsersE();

    List<PostsEntity> getPostsE();

    List<CommentEntity> getCommentsE();

    
    

    /* 
     * List<UsersEntity> getAllUsers();
     * UsersEntity getUserById(Long id);
     * Boolean ReplaceExistingUser(Long id, UsersEntity user);
     * List<PostsEntity> getAllPosts();
     * PostsEntity getPostById(@PathVariable Long id);
     * Boolean AddNewPost(@PathVariable Long id);
     * Boolean DeletePost(@PathVariable Long id)
     * List<CommentEntity> getAllComments();
     * CommentEntity getCommentById(@RequestParam Long id);
     * Boolean AddNewComment(@RequestParam Long id);
     * Boolean DeleteComment(@RequestParam Long id);
     */

    
}
