package com.example.bc_yahoo_finance.service;

import java.net.HttpCookie;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.bc_yahoo_finance.util.CookieStorage;

public class YahooFinanceService {
    private final RestTemplate restTemplate;
    private final CookieStorage cookieStorage;

    public YahooFinanceService(RestTemplate restTemplate, CookieStorage cookieStorage) {
        this.restTemplate = restTemplate;
        this.cookieStorage = cookieStorage;
    }

    // 使用 Cookie 發送 API 請求
    public String getQuoteData() {
        try {
            String url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=2318.HK&crumb=YOUR_CRUMB_VALUE";

            // 構建 Cookie 標頭
            HttpHeaders headers = new HttpHeaders();
            StringBuilder cookieHeader = new StringBuilder();

            for (HttpCookie cookie : cookieStorage.getAllCookies()) {
                cookieHeader.append(cookie.toString()).append("; ");
            }

            headers.add("Cookie", cookieHeader.toString());

            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 發送 GET 請求
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            return response.getBody();
        } catch (Exception e) {
            // 處理異常
            e.printStackTrace();
            return null;
        }
    }
}
