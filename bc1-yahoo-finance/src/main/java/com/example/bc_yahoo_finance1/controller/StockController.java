package main.java.com.example.bc_yahoo_finance1.controller;

import org.springframework.web.bind.annotation.GetMapping;

import main.java.com.example.bc_yahoo_finance1.model.Stock;

public interface StockController {
    @GetMapping("/test/stocks")
    publicList<Stock> getStocks();
}
