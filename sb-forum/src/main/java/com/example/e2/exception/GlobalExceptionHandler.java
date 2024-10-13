package com.example.e2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(HttpClientErrorException.NotFound.class)


    @ExceptionHandler(IllegalBoundaryException.class)


    @ExceptionHandler(RestClientException.class)


    @ExceptionHandler(Exception.class)
}
