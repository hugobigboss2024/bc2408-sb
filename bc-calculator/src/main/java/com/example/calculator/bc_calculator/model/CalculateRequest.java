package com.example.calculator.bc_calculator.model;

import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
@RestController
@Getter
@Setter
public class CalculateRequest {
    private String x;
    private String y;
    private String operation;

    // Getters and Setters
}