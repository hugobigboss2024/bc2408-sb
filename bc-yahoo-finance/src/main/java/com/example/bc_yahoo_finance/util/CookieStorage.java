package com.example.bc_yahoo_finance.util;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieStorage {
    private Map<String, HttpCookie> cookieMap = new HashMap<>();

    public void addCookie(HttpCookie cookie) {
        cookieMap.put(cookie.getName(), cookie);
    }

    public HttpCookie getCookie(String name) {
        return cookieMap.get(name);
    }

    public List<HttpCookie> getAllCookies() {
        return List.copyOf(cookieMap.values());
    }

    public void clearCookies() {
        cookieMap.clear();
    }
}
