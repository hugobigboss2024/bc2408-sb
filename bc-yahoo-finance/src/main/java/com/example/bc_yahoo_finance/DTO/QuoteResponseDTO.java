package com.example.bc_yahoo_finance.DTO;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@RestController
@Data
@Builder
public class QuoteResponseDTO {
    private List<ResultDTO> result;
}
