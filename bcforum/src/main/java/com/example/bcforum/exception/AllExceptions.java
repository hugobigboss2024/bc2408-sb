package com.example.bcforum.exception;



import lombok.Getter;

@Getter
public class AllExceptions extends RuntimeException{
    private int code;

    public static AllExceptions of(ErrorCode errorCode){
        return new AllExceptions(errorCode);
    }
    public static AllExceptions of(ErrorCode errorCode, String message){
        return new AllExceptions(errorCode, message);
    }
    public AllExceptions(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
    public AllExceptions(ErrorCode errorCode, String message){
        super(message);
        this.code = errorCode.getCode();
    }
}
