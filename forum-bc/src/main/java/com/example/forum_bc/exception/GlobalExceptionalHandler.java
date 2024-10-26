package com.example.forum_bc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
  @ExceptionHandler({ BusinessException.class })
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResp businessExceptionHandler(BusinessException e) {
    return ErrorResp.builder() //
        .code(e.getCode()) //
        .message(e.getMessage()) //
        .build();
  }
}
