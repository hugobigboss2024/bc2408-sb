package com.example.forum_bc.mapper;

import org.springframework.stereotype.Component;

import com.example.forum_bc.entity.UsersEntity;
import com.example.forum_bc.model.dto.UserDTO;

@Component
public class JPHMapper {
  public UsersEntity map(UserDTO userDTO) {

    return UsersEntity.builder()
        .name(userDTO.getName())
        .username(userDTO.getUsername())
        .email(userDTO.getEmail())
        .phone(userDTO.getPhone())
        .website(userDTO.getWebsite())
        .address(address)
        .company(userDTO.getCompany())
        .build();
  }

}
