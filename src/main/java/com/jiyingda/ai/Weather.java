/**
 * @(#)Weather.java, 1月 18, 2026.
 * <p>
 * Copyright 2026 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.ai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Simple weather CLI utility: query by city name (Chinese or English) and print current weather.
 *
 * Usage:
 *   java com.jiyingda.ai.Weather 北京
 *   java com.jiyingda.ai.Weather Shanghai
 */
public class Weather {

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) {
        String city = (args != null && args.length > 0 && args[0] != null && !args[0].trim().isEmpty())
                ? args[0].trim()
                : "北京"; // default
        try {
            double[] latlon = geocode(city);
            if (latlon == null) {
                System.out.println("未找到城市: " + city);
                return;
            }
            JSONObject current = getCurrentWeather(latlon[0], latlon[1]);
            if (current == null) {
                System.out.println("未获取到天气数据: " + city);
                return;
            }
            // Pretty print
            System.out.println("城市: " + city);
            System.out.println(String.format("坐标: %.4f, %.4f", latlon[0], latlon[1]));
            // Open-Meteo current_weather fields: temperature, windspeed, winddirection, weathercode, time
            if (current.containsKey("temperature")) {
                System.out.println("温度(°C): " + current.get("temperature"));
            }
            if (current.containsKey("windspeed")) {
                System.out.println("风速(km/h): " + current.get("windspeed"));
            }
            if (current.containsKey("winddirection")) {
                System.out.println("风向(°): " + current.get("winddirection"));
            }
            if (current.containsKey("weathercode")) {
                System.out.println("天气代码: " + current.get("weathercode"));
            }
            if (current.containsKey("time")) {
                System.out.println("时间: " + current.get("time"));
            }
        } catch (Exception e) {
            System.out.println("查询失败: " + e.getMessage());
        }
    }

    private static double[] geocode(String city) throws IOException {
        String url = "https://geocoding-api.open-meteo.com/v1/search?name="
                + URLEncoder.encode(city, StandardCharsets.UTF_8.name())
                + "&count=1&language=zh&format=json";
        JSONObject root = httpGetJson(url);
        if (root == null) return null;
        JSONArray results = root.getJSONArray("results");
        if (results == null || results.isEmpty()) return null;
        JSONObject first = results.getJSONObject(0);
        if (first == null) return null;
        Double lat = first.getDouble("latitude");
        Double lon = first.getDouble("longitude");
        if (lat == null || lon == null) return null;
        return new double[]{lat, lon};
    }

    private static JSONObject getCurrentWeather(double lat, double lon) throws IOException {
        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current_weather=true&timezone=auto", lat, lon);
        JSONObject root = httpGetJson(url);
        if (root == null) return null;
        return root.getJSONObject("current_weather");
    }

    private static JSONObject httpGetJson(String url) throws IOException {
        Request req = new Request.Builder()
                .url(url)
                .get()
                .header("Accept", "application/json")
                .header("User-Agent", "leetcode-weather-cli/1.0")
                .build();
        try (Response resp = CLIENT.newCall(req).execute()) {
            if (!resp.isSuccessful()) {
                throw new IOException("HTTP " + resp.code() + " - " + resp.message());
            }
            String body = Objects.requireNonNull(resp.body()).string();
            return JSON.parseObject(body);
        }
    }
}