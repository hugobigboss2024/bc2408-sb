package com.bootcamp.demo.demo_sb_restapi;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bootcamp.demo.demo_sb_restapi.service.JPHService;

@WebMvcTest
class JPHControllerTest {

    @MockBean
    private JPHService jphService;
}
