package com.example.bc_yahoo_finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "stock")
public class StockEntity {
    @Id
    private Long id;

}
