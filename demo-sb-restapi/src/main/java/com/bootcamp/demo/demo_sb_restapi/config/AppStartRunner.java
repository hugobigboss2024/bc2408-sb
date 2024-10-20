package com.bootcamp.demo.demo_sb_restapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello world");
    }

}
