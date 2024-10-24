package com.example.bc_yahoo_finance.util;

import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class YahooTest {

    public static void main(String[] args) {

        YahooFinance yh = new YahooFinance();
        System.out.println(yh.CONNECTION_TIMEOUT);
        System.out.println(yh.HISTQUOTES2_BASE_URL);
        System.out.println(yh.HISTQUOTES2_COOKIE);
        System.out.println(yh.HISTQUOTES2_COOKIE_AGREE);
        System.out.println(yh.HISTQUOTES2_COOKIE_NAMESPACE);
        System.out.println(yh.HISTQUOTES2_COOKIE_OATH_DONEURL);
        System.out.println(yh.HISTQUOTES2_COOKIE_OATH_HOST);
        System.out.println(yh.HISTQUOTES2_COOKIE_OATH_URL);
        System.out.println(yh.HISTQUOTES2_COOKIE_OATH_ORIGIN);
        System.out.println(yh.HISTQUOTES2_CRUMB);
        System.out.println(yh.HISTQUOTES2_CRUMB_URL);
        System.out.println(yh.HISTQUOTES2_ENABLED);
        System.out.println(yh.HISTQUOTES2_SCRAPE_URL);
        System.out.println(yh.HISTQUOTES_BASE_URL);
        System.out.println(yh.HISTQUOTES_QUERY2V8_BASE_URL);
        System.out.println(yh.QUOTES_BASE_URL);
        System.out.println(yh.QUOTES_CSV_DELIMITER);
        System.out.println(yh.QUOTES_QUERY1V7_BASE_URL);
        System.out.println(yh.QUOTES_QUERY1V7_ENABLED);
        System.out.println(yh.TIMEZONE);

        try {
            Stock stock = YahooFinance.get("INTC");
            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal change = stock.getQuote().getChange();

            System.out.println("Stock: " + stock.getSymbol());
            System.out.println("Price: " + price);
            System.out.println("Change: " + change);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
