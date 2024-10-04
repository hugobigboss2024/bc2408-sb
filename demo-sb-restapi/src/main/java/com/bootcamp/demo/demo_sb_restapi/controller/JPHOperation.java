package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

public interface JPHOperation {
    @GetMapping("/jph/users")
    List<UserDTO> getUsers();
}
