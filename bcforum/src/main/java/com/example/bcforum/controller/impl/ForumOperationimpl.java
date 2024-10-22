package com.example.bcforum.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcforum.controller.ForumOperation;
import com.example.bcforum.dto.UserCommentDto;
import com.example.bcforum.dto.UserDto;
import com.example.bcforum.dto.UserDto.PostDto;
import com.example.bcforum.dto.UserDto.PostDto.CommentDto;
import com.example.bcforum.entity.CommentEntity;
import com.example.bcforum.entity.PostsEntity;
import com.example.bcforum.entity.UsersEntity;
import com.example.bcforum.exception.AllExceptions;
import com.example.bcforum.exception.ErrorCode;
import com.example.bcforum.mapper.JPHMapper;
import com.example.bcforum.model.dto.CommentDTO;
import com.example.bcforum.model.dto.PostDTO;
import com.example.bcforum.model.dto.UserDTO;
import com.example.bcforum.service.ForumService;


@RestController
public class ForumOperationimpl implements ForumOperation{
    @Autowired
    private ForumService forumService;

    @Autowired
    private JPHMapper jphMapper;
    @Override
    public List<UserDto> getUsers(){
        List<UserDTO> usersData = this.forumService.getUsers();
        List<PostDTO> postsData = this.forumService.getPosts();
        List<CommentDTO> commentsData = this.forumService.getComments();
        return usersData.stream().map(u -> { //
            List<PostDto> postDtos = postsData.stream().filter(p -> p.getUserId() == p.getId())
             .map(p -> {List<CommentDto> commentDtos = commentsData.stream() //
                .filter(c -> c.getPostID() == p.getId()) //
                .map(c -> this.jphMapper.map(c)) //
                .collect(Collectors.toList());
            return this.jphMapper.map(p, commentDtos);
        }).collect(Collectors.toList());
          return this.jphMapper.map(u, postDtos);
        }).collect(Collectors.toList());
    }
    
    @Override
    public UserCommentDto getUserComments(String userId){
        Long StrUserId;
        try {
            StrUserId = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            throw AllExceptions.of(ErrorCode.USER_NOT_FOUND_EX);
        }
        List<UserDTO> usersData = this.forumService.getUsers();
        Optional<UserDTO> OPTuser = usersData.stream().filter(u -> u.getId().equals(StrUserId)).findAny();
        if(!OPTuser.isPresent())
        throw AllExceptions.of(ErrorCode.USER_NOT_FOUND_EX);
        List<PostDTO> postsData = this.forumService.getPosts();
        List<CommentDTO> commentsData = this.forumService.getComments();
        List<UserCommentDto.CommentDto> comments = postsData.stream() //
        .filter(p -> p.getId().equals(StrUserId)) //
        .flatMap(p -> commentsData.stream() //
        .filter(c -> c.getPostID().equals(p.getId())) //
        .map(c -> this.jphMapper.mapto(c))) //
        .collect(Collectors.toList());
        return UserCommentDto.builder().UserID(OPTuser.get().getId()).username(OPTuser.get().getUsername()).comments(comments).build();
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> usersData = this.forumService.getUsersE();
        return usersData;
    }

    @Override
    public UsersEntity getUserById(Long id) {
        List<UsersEntity> usersData = this.forumService.getUsersE();
        Optional<UsersEntity> OPTuser = usersData.stream().filter(u -> u.getId().equals(id)).findAny();
        if(!OPTuser.isPresent())
        throw AllExceptions.of(ErrorCode.USER_NOT_FOUND_EX);
        return OPTuser.get();
    }

    @Override
    public Boolean ReplaceExistingUser(Long id, UsersEntity user) {
        List<UsersEntity> usersData = this.forumService.getUsersE();
        Optional<UsersEntity> OPTuser = usersData.stream().filter(u -> u.getId().equals(id)).findAny();
        if(!OPTuser.isPresent())
        throw AllExceptions.of(ErrorCode.USER_NOT_FOUND_EX);
        OPTuser.get().setName(user.getName());
        return true;
    }

    @Override
    public List<PostsEntity> getAllPosts() {
        List<PostsEntity> postsData = this.forumService.getPostsE();
        return postsData;
    }

    @Override
    public PostsEntity getPostById(Long id) {
        List<PostsEntity> postsData = this.forumService.getPostsE();
        Optional<PostsEntity> OPTpost = postsData.stream().filter(p -> p.getId().equals(id)).findAny();
        if(!OPTpost.isPresent())
        throw AllExceptions.of(ErrorCode.POST_NOT_FOUND_EX);
        return OPTpost.get();
    }

    @Override
    public Boolean AddNewPost(Long id) {
        List<PostsEntity> postsData = this.forumService.getPostsE();
        PostsEntity post = PostsEntity.builder().id(id).build();
        postsData.add(post);
        return true;
    }

    @Override
    public Boolean DeletePost(Long id) {
        List<PostsEntity> postsData = this.forumService.getPostsE();
        Optional<PostsEntity> OPTpost = postsData.stream().filter(p -> p.getId().equals(id)).findAny();
        if(!OPTpost.isPresent())
        throw AllExceptions.of(ErrorCode.POST_NOT_FOUND_EX);
        postsData.remove(OPTpost.get());
        return true;
    }

    @Override
    public List<CommentEntity> getAllComments() {
        List<CommentEntity> commentsData = this.forumService.getCommentsE();
        return commentsData;
    }

    @Override
    public CommentEntity getCommentById(Long id) {
        List<CommentEntity> commentsData = this.forumService.getCommentsE();
        Optional<CommentEntity> OPTcomment = commentsData.stream().filter(c -> c.getId().equals(id)).findAny();
        if(!OPTcomment.isPresent())
        throw AllExceptions.of(ErrorCode.COMMENT_NOT_FOUND_EX);
        return OPTcomment.get();
    }

    @Override
    public Boolean AddNewComment(Long id) {
        List<CommentEntity> commentsData = this.forumService.getCommentsE();
        CommentEntity comment = CommentEntity.builder().id(id).build();
        commentsData.add(comment);
        return true;
    }

    @Override
    public Boolean DeleteComment(Long id) {
        List<CommentEntity> commentsData = this.forumService.getCommentsE();
        Optional<CommentEntity> OPTcomment = commentsData.stream().filter(c -> c.getId().equals(id)).findAny();
        if(!OPTcomment.isPresent())
        throw AllExceptions.of(ErrorCode.COMMENT_NOT_FOUND_EX);
        commentsData.remove(OPTcomment.get());
        return true;
    }

    
}
