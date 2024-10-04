package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.demo.demo_sb_restapi.dto.GovCatDTO;

@Controller
@ResponseBody
public class GovCatController {
  // Consideration: URL design (based on api consumer and resources)
  // return List<GovCatDTO>
  @GetMapping(value = "/govcats")
  public List<GovCatDTO> getGovCats() {
    return IntStream.range(1, 5)
        .mapToObj(i -> new GovCatDTO(10.0 + i))
        .collect(Collectors.toList());
  }
}