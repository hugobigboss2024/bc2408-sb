package main.java.com.example.bc_yahoo_finance1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bootcamp2408.bc_yahoo_finance.Entity.StockEntity;
import com.bootcamp2408.bc_yahoo_finance.Repositoy.StockRepository;

import main.java.com.example.bc_yahoo_finance1.infra.yahoo.CookieManager;
import main.java.com.example.bc_yahoo_finance1.infra.yahoo.CrumbManager;

@Component
public class AppStartRunner implements CommandLineRunner {

    @Autowired
    StockRepository stockRepository;

    private CrumbManager crumbManager;
    private CookieManager cookieManager;

    @Override
    public void run(String... args) throws Exception {

        List<StockEntity> stockEntities = List.of(
                new StockEntity("0388.HK"),
                new StockEntity("0700.HK"),
                new StockEntity("09988.HK"));

        this.stockRepository.saveAll(stockEntities);
    }

}
