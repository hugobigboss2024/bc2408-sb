package com.example.bc_yahoo_finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bc_yahoo_finance.entity.QuoteResponseEntity;
import com.example.bc_yahoo_finance.service.QuoteService;
import com.example.bc_yahoo_finance.util.CookieManager;

@RestController
public class FinanceController {

    @Autowired
    private CookieManager cookieManager;
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote/{symbol}")
    public QuoteResponseEntity getQuote(@PathVariable String symbol) {
        quoteService.fetchAndSaveQuote(symbol); // 抓取并保存数据
        return quoteService.getQuoteResponse(symbol); // 返回最新的 QuoteResponseEntity
    }

    @GetMapping("/get-cookie")
    public String retrieveCookie() {
        return cookieManager.getCookie(); // 獲取 Cookie
    }

    @RequestMapping("/test")
    public String getTest() {
        String test = "test";
        return test;
    }
}
