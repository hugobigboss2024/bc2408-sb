package com.example.calculator.bc_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.bc_calculator.exception.CalculateException;
import com.example.calculator.bc_calculator.model.CalculateRequest;
import com.example.calculator.bc_calculator.model.CalculateResponse;
import com.example.calculator.bc_calculator.model.Operation;
import com.example.calculator.bc_calculator.service.impl.CalculatorService;

@RestController
@RequestMapping("/operation")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public CalculateResponse calculateGet(@RequestParam String x, @RequestParam String y, @RequestParam String operation) {
        return processCalculation(x, y, operation);
    }

    @PostMapping
    public CalculateResponse calculatePost(@RequestBody CalculateRequest request) {
        return processCalculation(request.getX(), request.getY(), request.getOperation());
    }

    private CalculateResponse processCalculation(String x, String y, String operation) {
        switch (Operation.valueOf(operation.toUpperCase())) {
            case ADD:
                return new CalculateResponse(calculatorService.add(x, y));
            case SUBTRACT:
                return new CalculateResponse(calculatorService.sub(x, y));
            case MULTIPLY:
                return new CalculateResponse(calculatorService.mul(x, y));
            case DIVIDE:
                return new CalculateResponse(calculatorService.div(x, y));
            default:
                throw new CalculateException("Invalid operation");
        }
    }
}
