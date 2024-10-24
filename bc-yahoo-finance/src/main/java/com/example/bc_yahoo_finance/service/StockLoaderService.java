package com.example.bc_yahoo_finance.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bc_yahoo_finance.entity.StockEntity;
import com.example.bc_yahoo_finance.repository.StockRepository;

@Component
public class StockLoaderService implements CommandLineRunner {
    private final StockRepository stockRepository;

    public StockLoaderService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> symbols = Arrays.asList("0388.HK", "0700.HK");

        for (String symbol : symbols) {
            StockEntity stock = new StockEntity();
            stock.setSymbol(symbol);
            stockRepository.save(stock);
        }

        System.out.println("Stock symbols loaded to database.");
    }
}
