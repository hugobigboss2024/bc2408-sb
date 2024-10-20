package com.example.bcforum.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface TestOPeration {
    
    @GetMapping("/test")
    String test();
}
