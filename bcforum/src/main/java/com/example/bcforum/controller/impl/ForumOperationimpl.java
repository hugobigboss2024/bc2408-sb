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
        List<CommentDTO> commentsData = this.forumService.getComment();
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
        List<CommentDTO> commentsData = this.forumService.getComment();
        List<UserCommentDto.CommentDto> comments = postsData.stream() //
        .filter(p -> p.getId().equals(StrUserId)) //
        .flatMap(p -> commentsData.stream() //
        .filter(c -> c.getPostID().equals(p.getId())) //
        .map(c -> this.jphMapper.mapto(c))) //
        .collect(Collectors.toList());
        return UserCommentDto.builder().UserID(OPTuser.get().getId()).username(OPTuser.get().getUsername()).comments(comments).build();
    }

    
}
