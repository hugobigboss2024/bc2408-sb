package com.example.e2.dto;

import lombok.Data;

@Data // constructor, getter, setter
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    private Posts posts;
}
