package com.example.calculator.bc_calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.calculator.bc_calculator.service.CalculatorServiceImpl;
import com.example.calculator.bc_calculator.service.impl.CalculatorService;

@Configuration
public class AppConfig {

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorServiceImpl();
    }
}