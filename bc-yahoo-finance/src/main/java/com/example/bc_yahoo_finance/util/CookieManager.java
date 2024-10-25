package com.example.bc_yahoo_finance.util;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class CookieManager {
    private static final String YAHOO_FINANCE_URL = "https://finance.yahoo.com/";
    private RestTemplate restTemplate; // Tool A (Dependency of CookieManager)

    // Dependency Injection (Constructor Injection)
    public CookieManager(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Action B , requires Tool A
    public String getCookie() {
        // ResponseEntity<String> responseEntity =
        // this.restTemplate.getForEntity("https://finance.yahoo.com/",
        // String.class);
        // return responseEntity.getStatusCode();
        // return responseEntity.getHeaders().get("Set-Cookie").get(0);
        // return responseEntity.getBody(); // = getForBody()
        // HttpHeaders headers = responseEntity.getHeaders();
        // // 獲取 Set-Cookie 標頭
        // if (headers.containsKey("Set-Cookie")) {
        // return headers.get("Set-Cookie").get(0);
        // }
        // return null;

        try {
            ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(YAHOO_FINANCE_URL,
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

    public String getCookieKey() {
        String cookie = getCookie();
        try {
            return cookie.split(";")[0];
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        CookieManager cookieManager = new CookieManager(restTemplate);
        String cookie = cookieManager.getCookie();
        System.out.println("Cookie: " + cookie + "TestBy");
    }
}
