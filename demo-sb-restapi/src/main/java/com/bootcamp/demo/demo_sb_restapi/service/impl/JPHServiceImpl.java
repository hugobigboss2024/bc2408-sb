package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
@Service // Component annotation -> bean
public class JPHServiceImpl implements JPHService {
  @Override
  public List<UserDTO> getUsers() {
    UserDTO[] users = new RestTemplate().getForObject(
        "https://jsonplaceholder.typicode.com/users", UserDTO[].class);
    return List.of(users);
  }
}