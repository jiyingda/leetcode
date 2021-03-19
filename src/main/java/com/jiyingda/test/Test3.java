/**
 * @(#)Test3.java, 3月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Test3 {

    public static void main(String[] args) throws IOException, UnirestException {

        Unirest.setTimeouts(3000, 3000);
        HttpResponse<String> response = Unirest.post("http://es-cn-6ja21yyqk000wnq1c.elasticsearch.aliyuncs.com:9200/user-index/_search")
                .header("Connection", "keep-alive")
                .header("Authorization", "Basic ZWxhc3RpYzpURWxhc3RpYzQ1Ng==")
                .header("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36")
                .header("Content-Type", "application/json")
                .header("Origin", "chrome-extension://ffmkiejjmecolpfloofpjologoblkegm")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .body("{\"query\":{\"bool\":{\"must\":[{\"match_all\":{}}],\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":1000,\"sort\":[],\"aggs\":{}}")
                .asString();
        //System.out.println(JSON.toJSONString(response.getBody()));
        JSONObject obj = (JSONObject) JSONObject.parse(response.getBody());
        JSONObject obj2 = obj.getJSONObject("hits");
        JSONArray arr = obj2.getJSONArray("hits");
        List<String> sss = new ArrayList<>();
        for (Object oo : arr.toArray()) {
            JSONObject tmp = (JSONObject)oo;
            JSONObject tmp2 = tmp.getJSONObject("_source");
            String s = tmp2.getString("nameLowerCase");
            if (!"".equals(s)) {
                sss.add(s);
            }

        }
        System.out.println(JSON.toJSONString(sss));



    }

    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }
}
