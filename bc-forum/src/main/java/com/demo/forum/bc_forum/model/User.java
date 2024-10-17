package com.demo.forum.bc_forum.model;

import java.util.List;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    private List<Post> posts;
}
