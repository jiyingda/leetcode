/**
 * @(#)Test123.java, 7月 17, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class Test123 {

    public static void main(String[] args) {
        String s = FileReader.readFromVsV2("bookversion-config.json");
        List<String> qz = FileReader.readFromVs("权重");
        Map<Integer, Integer> qzMap = new HashMap<>();
        for (String q : qz) {
            String[] qq = q.split("\t");
            if (qq.length == 2) {
                qzMap.put(Integer.parseInt(qq[1]), Integer.parseInt(qq[0]));
            }
        }
        String st = "{\"10\":1001, \"11\":1002, \"12\":1003, \"16\":1006, \"17\":1025, \"13\":1004, \"14\":1110, \"15\":1042, \"18\":1005, \"19\":1028, \"20\":1033}";
        String kkk = "1.23\n" +
                "1.24\n" +
                "1.13\n" +
                "1.21\n" +
                "1.22\n" +
                "1.20\n" +
                "default\n" +
                "1.18\n" +
                "1.19\n" +
                "2.0\n" +
                "1.27\n" +
                "1.16\n" +
                "2.1\n" +
                "1.28\n" +
                "1.17\n" +
                "2.2\n" +
                "1.25\n" +
                "1.14\n" +
                "2.3\n" +
                "1.26\n" +
                "1.15\n" +
                "2.4\n";
        String[] kkkk = kkk.split("\n");
        Arrays.sort(kkkk);
        int l = kkkk.length;


        //Map<String, JSONObject> map = JSONObject.parseObject(s, Map.class);
        JSONObject jsonObject = JSONObject.parseObject(s);
        Map<String, Integer> set = JSONObject.parseObject(st, Map.class);
        List<JSONObject> llllllll = new ArrayList<>();
        for (int j = l -1; j >= 0; j--) {
            JSONObject v = jsonObject.getJSONObject(kkkk[j]);
            JSONArray array = v.getJSONArray("config");
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                int b = obj.getInteger("bookVersion");
                String n = obj.getString("name");
                String weight = obj.getString("weight");
                int newW = qzMap.getOrDefault(b, -1);
                if (set.containsKey("" + b)) {
                    newW = qzMap.getOrDefault(set.get("" + b), -1);
                }

                if (newW == -1) {
                    //System.out.println(b + "\t" + n + "\t"+ weight + "->" +  newW);
                }
                obj.put("weight", newW);
                //System.out.println(b + "\t" + n + "\t"+ weight + "->" +  newW);
            }
            System.out.println("\"" + kkkk[j] + "\":" + v.toJSONString() + ",");
            llllllll.add(v);
        }
        //System.out.println(jsonObject.toJSONString());


    }


}
