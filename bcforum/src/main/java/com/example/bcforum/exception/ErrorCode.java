package com.example.bcforum.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND_EX(1, "User not found"),
    INV_INPUT_EX(2, "Invalid input"),
    REST_CLIENT_EX(3, "Rest client error"),
    POST_NOT_FOUND_EX(4, "Post not found"), 
    COMMENT_NOT_FOUND_EX(5, "Comment not found");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
