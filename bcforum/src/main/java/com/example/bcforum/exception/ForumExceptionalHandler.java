package com.example.bcforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ForumExceptionalHandler {
    @ExceptionHandler({AllExceptions.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResp allExceptionsHandler(AllExceptions e){
        return ErrorResp.builder().code(e.getCode()).message(e.getMessage()).build();
    }

}