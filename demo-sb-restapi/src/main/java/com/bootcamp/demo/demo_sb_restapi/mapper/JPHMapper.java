package com.bootcamp.demo.demo_sb_restapi.mapper;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

public class JPHMapper {
    public static UserEntity map(UserDTO userDTO) {
        return UserEntity.builder() //
                .addrLat(userDTO.getAddress().getGeo().getLat()) //
                // ...
                .build();
    }
}