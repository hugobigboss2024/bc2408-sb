package com.example.bcforum.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.example.bcforum.controller.TestOPeration;
@RestController
public class TestController implements TestOPeration{
    

    @Override
    public String test() {
        return "test";
    }
}
