package com.example.bc_yahoo_finance.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@Table(name = "QUOTE_RESPONSE")
public class QuoteResponseEntity {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String error = "ERROR";

    @OneToMany(mappedBy = "quoteResponse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "TSTOCK_QUOTE_YAHOO")
    private List<ResultEntity> result;
}
