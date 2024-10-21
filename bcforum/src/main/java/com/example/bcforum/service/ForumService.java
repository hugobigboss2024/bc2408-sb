package com.example.bcforum.service;

import java.util.List;
import java.util.Optional;

import com.example.bcforum.entity.CommentEntity;
import com.example.bcforum.entity.PostsEntity;
import com.example.bcforum.entity.UsersEntity;
import com.example.bcforum.model.dto.CommentDTO;
import com.example.bcforum.model.dto.PostDTO;
import com.example.bcforum.model.dto.UserDTO;

public interface ForumService {
    List<UserDTO> getUsers();

    List<PostDTO> getPosts();

    List<CommentDTO> getComment();

    /////////////////////////////////
    UsersEntity createUsers(UsersEntity user);

    Boolean deleteUsers(Long id);

    UsersEntity updateUsers(Long id, UsersEntity user);

    UsersEntity pathUserWebsite(Long id, String website);

    Optional<UsersEntity> findByUsername(String username);

    UsersEntity getUserById(Long id);

    PostsEntity createPosts(PostsEntity post);

    List<PostsEntity> getAllPosts();

    PostsEntity getPostById(Long id);

    Boolean AddNewPost(Long id);

    Boolean DeletePost(Long id);

    List<CommentEntity> getAllComments();

    CommentEntity getCommentById(Long id);

    Boolean AddNewComment(Long id);

    Boolean DeleteComment(Long id);

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
