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
import com.jiyingda.util.FileWriter;

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
        // 查询2026-01-18北京天气
    }

    public static void main2(String[] args) {
        List<String> array = FileReader.readFromVs("wxlj");
        List<String> out = new ArrayList<>();
        for (String s : array) {
            String[] ss = s.split(", ");
            if (ss.length < 2) {
                continue;
            }
            out.add(ss[1] + "," + ss[2]);
            System.out.println(ss[1] + "," + ss[2]);
        }
        FileWriter.write("wx0115.csv", out);


    }


}
