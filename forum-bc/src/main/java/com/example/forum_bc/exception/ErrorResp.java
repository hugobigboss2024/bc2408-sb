package com.example.forum_bc.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResp {
  private Integer code;
  private String message;
}
