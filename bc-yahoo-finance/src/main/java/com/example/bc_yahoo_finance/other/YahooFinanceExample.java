package com.example.bc_yahoo_finance.other;

import java.io.IOException;
import java.util.List;

import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.stock.StockQuote;

public class YahooFinanceExample {
    public static void main(String[] args) {
        try {
            // 獲取單個股票的即時價格
            StockQuote quote = YahooFinance.get("AAPL").getQuote();
            System.out.println("Apple's current price: " + quote.getPrice());

            // 獲取股票的歷史數據
            List<HistoricalQuote> history = YahooFinance.get("AAPL").getHistory();
            for (HistoricalQuote histQuote : history) {
                System.out.println(histQuote.getDate() + " -> " + histQuote.getClose());
            }

            // 獲取特定時間範圍的歷史數據
            List<HistoricalQuote> historyFromTo = YahooFinance.get("AAPL").getHistory(Interval.DAILY);
            for (HistoricalQuote histQuote : historyFromTo) {
                System.out.println(histQuote.getDate() + " -> " + histQuote.getClose());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
