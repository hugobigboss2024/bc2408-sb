package com.example.bcforum.model.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
    private Long postID;
    private Long id;
    private String name;
    private String email;
    private String body;
}
