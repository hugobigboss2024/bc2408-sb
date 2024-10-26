package main.java.com.example.bc_yahoo_finance1.config;

import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.bootcamp2408.bc_yahoo_finance.infra.yahoo.CookieManager;

import main.java.com.example.bc_yahoo_finance1.infra.yahoo.CrumbManager;

@Configuration
public class AppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CookieManager cookieManager(RestTemplate restTemplate) {
        return new CookieManager(restTemplate);
    }

    @Bean
    CrumbManager crumbManager(RestTemplate restTemplate) {
        return new CrumbManager(restTemplate);
    }
}
