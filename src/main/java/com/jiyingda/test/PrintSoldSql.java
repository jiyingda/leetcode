/**
 * @(#)PrintSoldSeviceSql.java, 9月 13, 2022.
 * <p>
 * Copyright 2022 y . All rights reserved.
 *  .COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
public class PrintSoldSql {

    public static void main(String[] args) throws IOException {

        File preTimeFile = new File("/Users/jiyingda/vs/a123out");
        if (preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String key = line;
                System.out.println(key);

            }
        }



        /*File preTimeFile = new File("/Users/jiyingda/vs/yfda1");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String sql = "replace into `sold_device` ( `clientId`, `sold`) values ( '" + line + "', '1');";
                System.out.println(sql);
            }
        }*/
    }
}