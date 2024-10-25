package com.example.bc_yahoo_finance.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class YahooFinanceScraper {
    public static void main(String[] args) {
        String symbol = "0006.HK"; // 股票代码
        String url = "https://finance.yahoo.com/quote/" + symbol;

        try {
            // 连接到网页
            Document doc = Jsoup.connect(url).get();

            // 查找当前价格
            Element priceElement = doc.selectFirst("fin-streamer[data-field='regularMarketPrice']");
            Element updataTime = doc.selectFirst("fin-streamer[data-field='regularMarketTime']");
            Element change = doc.selectFirst("fin-streamer[data-field='regularMarketChange']");
            // Element language =
            // doc.selectFirst("fin-streamer[data-field='regularMarketPriceCurrency']");
            Element region = doc.selectFirst("fin-streamer[data-field='regularMarketRegion']");
            Element qutoeType = doc.selectFirst("fin-streamer[data-field='regularMarketQuoteType']");
            String price = priceElement.text();
            String updateTime = updataTime.text();
            String changePrice = change.text();
            // String languagePrice = language.text();
            String regionPrice = region.text();
            String qutoeTypePrice = qutoeType.text();

            // 输出价格
            System.out.println("Current price of " + symbol + ": " + price); // 51.550 at 1406
            System.out.println("Current update time of " + symbol + ": " + updateTime); // ?
            System.out.println("Current change price of " + symbol + ": " + changePrice); // -0.200
            // System.out.println("Current language price of " + symbol + ": " +
            // languagePrice); // HKD
            System.out.println("Current region price of " + symbol + ": " + regionPrice); // ?
            System.out.println("Current qutoeType price of " + symbol + ": " + qutoeTypePrice); // ?
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}