import org.jsoup.Jsoup;

public class YahooFinanceScraper {
    public static void main(String[] args) {
        String symbol = "0005.HK"; // 股票代码
        String url = "https://finance.yahoo.com/quote/" + symbol;

        try {
            // 连接到网页
            Document doc = Jsoup.connect(url).get();

            // 查找当前价格
            Element priceElement = doc.selectFirst("fin-streamer[data-field='regularMarketPrice']");
            String price = priceElement.text();

            // 输出价格
            System.out.println("Current price of " + symbol + ": " + price);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}