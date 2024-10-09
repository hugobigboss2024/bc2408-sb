package com.example.calculator.bc_calculator.infra;



import java.math.BigDecimal;

import com.example.calculator.bc_calculator.exception.CalculateException;
public class ApiUtil {
    public static void validateInput(String x, String y) {
        try {
            new BigDecimal(x);
            new BigDecimal(y);
        } catch (NumberFormatException ex) {
            throw new CalculateException("Invalid input");
        }
    }
}