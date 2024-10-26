package com.example.forum_bc.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum_bc.controller.JPHOperation;
import com.example.forum_bc.mapper.JPHMapper;
import com.example.forum_bc.service.JPHService;

@RestController
public class JPHController implements JPHOperation {
  @Autowired
  private JPHService jphService;

  @Autowired
  private JPHMapper jphMapper;

}
