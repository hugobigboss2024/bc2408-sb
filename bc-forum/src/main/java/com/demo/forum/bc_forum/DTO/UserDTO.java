package com.demo.forum.bc_forum.DTO;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
    private List<PostDTO> posts;
}
