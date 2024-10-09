package com.example.calculator.bc_calculator.model;

import lombok.Getter;

@Getter
public class CalculateResponse {
    private String result;

    public CalculateResponse(String result) {
        this.result = result;
    }

    // Getter
}