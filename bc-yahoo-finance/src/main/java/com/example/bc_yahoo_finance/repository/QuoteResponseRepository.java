package com.example.bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bc_yahoo_finance.entity.QuoteResponseEntity;

public interface QuoteResponseRepository extends JpaRepository<QuoteResponseEntity, Long> {
    // 根据 ID 查找
    // QuoteResponseEntity findById(Long id);

    // 根据符号查找
    QuoteResponseEntity findByResultSymbol(String symbol);
}
