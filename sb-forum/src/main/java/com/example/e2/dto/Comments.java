package com.example.e2.dto;

import lombok.Data;

@Data
public class Comments {
    private Long id;
    private String name;
    private String email;
    private String body;
}
