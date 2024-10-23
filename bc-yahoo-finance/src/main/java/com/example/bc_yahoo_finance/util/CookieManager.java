package com.example.bc_yahoo_finance.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CookieManager {
    private RestTemplate restTemplate;

    public CookieManager(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCookie() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("https://finance.yahoo.com/",
                String.class);
        return responseEntity.getHeaders().get("Set-Cookie").get(0);
    }
}
