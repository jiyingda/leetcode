/**
 * @(#)RedisKey.java, 12月 20, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class RedisKey {

    public static void main(String[] args) throws IOException {
        File preTimeFile = new File("/Users/jiyingda/vs/a12");
        FileWriter fileWriter = new FileWriter("/Users/jiyingda/vs/a1234out");
        List<String> array =  new ArrayList<>();
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] ss = line.split(" \u0001");
                try {
                    String[] uu  = ss[16].split("=");
                    if ("@__user_id__".equals(uu[0])) {

                    } else {
                        String user = getSSSss(ss);
                        if (user != null) {
                            String sssss = "megrez:" + user + ":" + getSSS(ss[5]) + ":" + getSSS(ss[6] + "\n");
                            fileWriter.append(sssss);
                        }
                    }

                } catch (Exception e) {
                    System.out.println(line);
                }


            }
        }

        fileWriter.close();
    }

    private static String getSSS(String s) {
        return s.split("=")[1];
    }

    private static String getSSSss(String[] s) {
        for (String ss : s) {
            String[] aa = ss.split("=");
            if ("@__user_id__".equals(aa[0])) {
                return aa[1];
            }
        }
        return null;
    }
}
