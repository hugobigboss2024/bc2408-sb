package com.example.bcforum.service;

import java.util.List;

import com.example.bcforum.model.dto.CommentDTO;
import com.example.bcforum.model.dto.PostDTO;
import com.example.bcforum.model.dto.UserDTO;

public interface ForumService {
    List<UserDTO> getUsers();

    List<PostDTO> getPosts();

    List<CommentDTO> getComment();
}
