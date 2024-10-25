package com.example.bc_yahoo_finance.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlphaVantageExample {
    public static void main(String[] args) {
        String apiKey = "V8NJVZEMFZUL4BCJ"; // 獲取你的 Alpha Vantage API 金鑰
        String symbol = "AAPL";
        String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey;

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());
            } else {
                System.out.println("Error: HTTP response code " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
