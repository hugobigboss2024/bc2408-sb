package com.example.calculator.bc_calculator.model;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // Getters
}