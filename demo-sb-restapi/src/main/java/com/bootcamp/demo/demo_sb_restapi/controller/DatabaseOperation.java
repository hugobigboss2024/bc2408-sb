package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//
public interface DatabaseOperation {
    @GetMapping("/integers/put/{index}/{value}")
    public int put(@PathVariable int index, @PathVariable int value);

    @GetMapping("/integers/get/{index}")
    public int get(@PathVariable int index);

    @GetMapping("/integers/getall")
    public List<Integer> getAll();
}
