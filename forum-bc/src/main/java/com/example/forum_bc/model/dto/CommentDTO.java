package com.example.forum_bc.model.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
