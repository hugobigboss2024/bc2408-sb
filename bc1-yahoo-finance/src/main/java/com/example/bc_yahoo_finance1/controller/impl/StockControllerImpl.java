package main.java.com.example.bc_yahoo_finance1.controller.impl;

import main.java.com.example.bc_yahoo_finance1.controller.StockController;
import main.java.com.example.bc_yahoo_finance1.model.Stock;

@RestController
public class StockControllerImpl implements StockController {

    @Override
    public String getStock() {
        return Stock.class.getName();
    }
}
