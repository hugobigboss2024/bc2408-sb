package com.example.bc_yahoo_finance.test;

import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.example.bc_yahoo_finance.entity.ResultEntity;

public class StockDataFetcher {
    public ResultEntity fetchStockData(String symbol) {
        ResultEntity resultEntity = new ResultEntity();

        try {
            // 构建 URL
            String url = "https://finance.yahoo.com/quote/" + symbol;
            Document doc = Jsoup.connect(url).get();

            // 抓取数据并设置到 ResultEntity 中
            resultEntity.setLanguage("en"); // 示例值
            resultEntity.setRegion("HK"); // 示例值
            resultEntity.setQuoteType("EQUITY"); // 示例值
            resultEntity.setTypeDisp("Stock"); // 示例值
            resultEntity.setQuoteSourceName("Yahoo Finance"); // 示例值
            resultEntity.setTriggerable(false); // 示例值
            resultEntity.setCustomPriceAlertConfidence("High"); // 示例值

            // 抓取市场变化百分比
            Element changePercentElement = doc.selectFirst("fin-streamer[data-field='regularMarketChangePercent']");
            if (changePercentElement != null) {
                resultEntity.setRegularMarketChangePercent(
                        new BigDecimal(changePercentElement.text().replace("%", "").trim()));
            }

            // 抓取市场价格
            Element priceElement = doc.selectFirst("fin-streamer[data-field='regularMarketPrice']");
            if (priceElement != null) {
                resultEntity.setRegularMarketPrice(new BigDecimal(priceElement.text().replace(",", "")));
            }

            // 抓取货币
            Element currencyElement = doc.selectFirst("span[data-testid='currency-symbol']");
            if (currencyElement != null) {
                resultEntity.setCurrency(currencyElement.text());
            }

            // 抓取 52 周低变化
            Element fiftyTwoWeekLowChangeElement = doc.selectFirst("fin-streamer[data-field='fiftyTwoWeekLowChange']");
            if (fiftyTwoWeekLowChangeElement != null) {
                resultEntity
                        .setFiftyTwoWeekLowChange(new BigDecimal(fiftyTwoWeekLowChangeElement.text().replace(",", "")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultEntity;
    }

    public static void main(String[] args) {
        StockDataFetcher fetcher = new StockDataFetcher();
        String symbol = "0006.HK"; // 股票代码
        ResultEntity result = fetcher.fetchStockData(symbol);

        // 打印抓取的数据
        System.out.println("Language: " + result.getLanguage());
        System.out.println("Region: " + result.getRegion());
        System.out.println("Quote Type: " + result.getQuoteType());
        System.out.println("Type Display: " + result.getTypeDisp());
        System.out.println("Quote Source Name: " + result.getQuoteSourceName());
        System.out.println("Triggerable: " + result.isTriggerable());
        System.out.println("Custom Price Alert Confidence: " + result.getCustomPriceAlertConfidence());
        System.out.println("Regular Market Change Percent: " + result.getRegularMarketChangePercent());
        System.out.println("Regular Market Price: " + result.getRegularMarketPrice());
        System.out.println("Currency: " + result.getCurrency());
        System.out.println("52 Week Low Change: " + result.getFiftyTwoWeekLowChange());

    }
}