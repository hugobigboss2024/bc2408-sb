package com.example.bcforum.model.dto;

import lombok.Getter;

@Getter
public class PostDTO {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
