/**
 * @(#)MyMoney.java, 12月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiyingda
 */
public class MyMoney {


    public static void main(String[] args) throws IOException {
        int sum = 0;
        File preTimeFile = new File("/Users/jiyingda/vscode/005548");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
                sum += Integer.parseInt(line);
            }
        }
        Date now = new Date();
        String s = now.getTime() + "," + sum;
        System.out.println(s);

        Files.write(Paths.get("/Users/jiyingda/vscode/income"), s.getBytes());
    }
}