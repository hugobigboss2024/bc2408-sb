package com.example.bcforum.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommentDto {
    @JsonProperty(value = "ID")
    private Long UserID;
    private String username;
    private List<CommentDto> comments;

    @Getter
    @Builder
    public static class CommentDto {
        private String name;
        private String email;
        private String body;
    }
}
