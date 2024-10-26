
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YahooFinanceExample {
    public static void main(String[] args) {
        String symbol = "0005.HK"; // 股票代码
        String urlString = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=" + symbol;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 输出响应
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}