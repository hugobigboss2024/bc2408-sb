package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

public interface JPHOperation {
    @GetMapping("/jph/users")
    List<UserDTO> getUsers();

    @PostMapping("/jph/users")
    List<UserEntity> createUsers();

    @DeleteMapping("/jph/user")
    Boolean deleteUsers(@RequestParam Long id);

    @PutMapping("/jph/user") // by pk
    UserEntity updateUser(@RequestParam Long id, @RequestBody UserEntity entity);
}
