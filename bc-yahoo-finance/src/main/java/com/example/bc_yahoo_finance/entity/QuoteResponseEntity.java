package com.example.bc_yahoo_finance.entity;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "QUOTE_RESPONSE")
public class QuoteResponseEntity {
    @Id
    private Long id;
    private String error = "ERROR";

    @OneToMany(mappedBy = "quoteResponse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "TSTOCK_QUOTE_YAHOO")
    private List<ResultEntity> result;

    // 获取 ResultEntity 的符号
    public Optional<String> getResultSymbol() {
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0).getSymbol());
        }
        return Optional.empty();
    }
}
