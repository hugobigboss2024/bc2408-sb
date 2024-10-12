package com.example.e2.dto;

import lombok.Data;

@Data
public class Posts {
    private Long id;
    private String title;
    private String body;
    private Comments comments;

}
