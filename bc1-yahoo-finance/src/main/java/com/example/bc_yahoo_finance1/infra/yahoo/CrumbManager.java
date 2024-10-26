package main.java.com.example.bc_yahoo_finance1.infra.yahoo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CrumbManager {

    @Autowired
    private CookieManager cookieManager;

    private static final String CRUMB_URL = "https://query1.finance.yahoo.com/v1/test/getcrumb";
    private RestTemplate restTemplate; // Tool A (Dependency of CookieManager)

    // Dependency Injection (Constructor Injection)
    public CrumbManager(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Action B, requires Tool A and CookieManager
    public String getCrumb() throws IOException, InterruptedException {
        String cookies = this.cookieManager.getCookie();
        System.out.println("cookie : " + cookies);

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(CRUMB_URL))
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "*/*")
                .header("Cookie", cookies) // Pass cookies in the request
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        // The crumb is typically in the body of the response
        String crumb = httpResponse.body();
        System.out.println("Crumb: " + crumb);

        return crumb;
    }

}
