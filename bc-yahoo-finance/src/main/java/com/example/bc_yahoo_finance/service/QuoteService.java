package com.example.bc_yahoo_finance.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bc_yahoo_finance.entity.QuoteResponseEntity;
import com.example.bc_yahoo_finance.entity.ResultEntity;
import com.example.bc_yahoo_finance.repository.QuoteResponseRepository;

@Service
public class QuoteService {
    @Autowired
    private QuoteResponseRepository quoteResponseRepository;
    @Autowired
    private ResultEntity result;
    @Autowired
    private QuoteResponseEntity quoteResponse;

    public void fetchAndSaveQuote(String symbol) {
        try {
            String url = "https://finance.yahoo.com/quote/" + symbol;
            Document doc = Jsoup.connect(url).get();

            // 创建 ResultEntity 实例并抓取数据

            Element priceElement = doc.selectFirst("fin-streamer[data-field='regularMarketPrice']");
            result.setRegularMarketPrice(new BigDecimal(priceElement.text().replace(",", "")));
            result.setSymbol(symbol);
            // 继续抓取其他数据并设置到 result...

            // 创建 QuoteResponseEntity 实例

            quoteResponse.setResult(new ArrayList<>());
            quoteResponse.getResult().add(result);

            // 保存到数据库
            quoteResponseRepository.save(quoteResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QuoteResponseEntity findById(Long id) {
        return null;
    }

    public QuoteResponseEntity getQuoteResponse(String symbol) {
        return quoteResponseRepository.findByResultSymbol(symbol);
    }
}