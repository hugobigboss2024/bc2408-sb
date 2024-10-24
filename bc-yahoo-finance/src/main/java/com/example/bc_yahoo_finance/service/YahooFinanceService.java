package com.example.bc_yahoo_finance.service;

import java.net.HttpCookie;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
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
    public String getQuoteData(String crumbValue) {
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

    private String getCrumbKey() {
        try {
            ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("https://finance.yahoo.com/",
                    String.class);
            List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");
            return cookies.get(0).split(";")[0];
        } catch (HttpClientErrorException e) {
            HttpHeaders headers = e.getResponseHeaders();
            List<String> cookies = headers == null ? null : headers.get("Set-Cookie");
            if (cookies == null || cookies.isEmpty()) {
                return null;
            }
            return cookies.get(0).split(";")[0];
        }
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        CookieStorage cookieStorage = new CookieStorage(null); // 确保实现了正确的 Cookie 存储
        YahooFinanceService service = new YahooFinanceService(restTemplate, cookieStorage);

        String crumbKey = service.getCrumbKey();
        System.out.println("Crumb Key: " + crumbKey + "TestBy");

        String quoteData = service.getQuoteData(crumbKey);
        System.out.println("Quote Data: " + quoteData + "TestBy");
    }

}
