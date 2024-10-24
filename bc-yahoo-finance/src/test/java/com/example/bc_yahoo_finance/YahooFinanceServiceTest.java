package com.example.bc_yahoo_finance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.net.HttpCookie;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.bc_yahoo_finance.service.YahooFinanceService;
import com.example.bc_yahoo_finance.util.CookieStorage;

public class YahooFinanceServiceTest {

    private YahooFinanceService yahooFinanceService;
    private RestTemplate restTemplate;
    private CookieStorage cookieStorage;

    @BeforeEach
    public void setUp() {
        restTemplate = Mockito.mock(RestTemplate.class);
        cookieStorage = Mockito.mock(CookieStorage.class);
        yahooFinanceService = new YahooFinanceService(restTemplate, cookieStorage);
    }

    @Test
    public void testGetQuoteData() {
        String crumbValue = "mockCrumbValue";
        String mockResponse = "{\"quoteResponse\": {\"result\": [{\"symbol\": \"2318.HK\"}]}}";

        // 模拟 Cookie 返回
        HttpCookie mockCookie = new HttpCookie("mockCookie", "value");
        when(cookieStorage.getAllCookies()).thenReturn(Arrays.asList(mockCookie));

        // 模拟 RestTemplate 返回
        when(restTemplate.exchange(anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(), Mockito.eq(String.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        // 调用方法并验证结果
        String result = yahooFinanceService.getQuoteData(crumbValue);
        assertEquals(mockResponse, result);
    }
}