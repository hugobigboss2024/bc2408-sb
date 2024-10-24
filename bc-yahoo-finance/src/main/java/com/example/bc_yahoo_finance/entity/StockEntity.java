package com.example.bc_yahoo_finance.entity;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@RestController
@Table(name = "stock")
public class StockEntity {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String symbol;

    public StockEntity() {
    }

    public StockEntity(Long id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

}
