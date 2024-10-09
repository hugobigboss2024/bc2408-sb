package com.example.calculator.bc_calculator.model;

public enum  Operation{
    ADD("add"),
    SUBTRACT("sub"),
    MULTIPLY("mul"),
    DIVIDE("div");
    //定義計算的可用操作（如加法、減法、乘法、除法）。用 enum 來限制操作類型，使其更加可控和易於管理。

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation(){
        return operation;
    }

    public static Operation fromString(String operation){
        for (Operation op : Operation.values()) {
            if(op.getOperation().equalsIgnoreCase(operation)){
                return op;
            }
            }
        throw new IllegalArgumentException("Invalid operation: " + operation);
    }

}