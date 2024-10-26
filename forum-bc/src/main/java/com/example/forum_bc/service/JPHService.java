package com.example.forum_bc.service;

import java.util.List;

import com.example.forum_bc.model.dto.CommentDTO;
import com.example.forum_bc.model.dto.PostDTO;
import com.example.forum_bc.model.dto.UserDTO;

public interface JPHService {
  /**
   * GET all Users: https://jsonplaceholder.typicode.com/users
   * 
   * @return
   */
  List<UserDTO> getUsers();

  /**
   * GET all Posts: https://jsonplaceholder.typicode.com/posts
   * 
   * @return
   */
  List<PostDTO> getPosts();

  /**
   * GET all Comments: https://jsonplaceholder.typicode.com/comments
   * 
   * @return
   */
  List<CommentDTO> getComments();
}
