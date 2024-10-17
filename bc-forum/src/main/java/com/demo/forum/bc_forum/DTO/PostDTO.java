package com.demo.forum.bc_forum.DTO;

import java.util.List;

import lombok.Data;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;
}
