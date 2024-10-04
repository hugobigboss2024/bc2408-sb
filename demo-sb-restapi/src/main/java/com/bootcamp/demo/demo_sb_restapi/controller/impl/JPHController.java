package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restapi.controller.JPHOperation;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.service.impl.JPHServiceImpl;

// A new Thread
// JPHController c = get bean from Context
// c.getUsers();
@RestController
public class JPHController implements JPHOperation {
    private static String x = "abc";
    // Controller Layer -> Service Layer
    // ! Autowired (Bean Injection)
    // Before Server start:
    // Spring check if there is a bean from Spring Context can be injected into this
    // object reference
    // What if not found ? Server start fail ....
    // After Server start:
    // API request comes... jphController Bean calls jphService Bean
    @Autowired
    private JPHService jphService;

    @Override
    public List<UserDTO> getUsers() {
        return new JPHServiceImpl().getUsers();
    }
}
