package com.example.calculator.bc_calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.calculator.bc_calculator.service.impl.CalculatorService;



public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String add(String x, String y) {
        BigDecimal result = new BigDecimal(x).add(new BigDecimal(y));
        return result.toString();
    }

    @Override
    public String sub(String x, String y) {
        BigDecimal result = new BigDecimal(x).subtract(new BigDecimal(y));
        return result.toString();
    }

    @Override
    public String mul(String x, String y) {
        BigDecimal result = new BigDecimal(x).multiply(new BigDecimal(y));
        return result.toString();
    }

    @Override
    public String div(String x, String y) {
        BigDecimal result = new BigDecimal(x).divide(new BigDecimal(y), 5, RoundingMode.HALF_UP);
        return result.toString();
    }
}