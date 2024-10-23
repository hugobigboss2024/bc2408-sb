package com.example.bc_yahoo_finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bc_yahoo_finance.util.CookieManager;

@RestController
public class FinanceController {
    private final CookieManager cookieManager;

    @Autowired
    public FinanceController(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    @GetMapping("/get-cookie")
    public String retrieveCookie() {
        return cookieManager.getCookie(); // 獲取 Cookie
    }
}
