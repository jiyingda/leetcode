/**
 * @(#)PrintSoldSeviceSql.java, 9月 13, 2022.
 * <p>
 * Copyright 2022 y . All rights reserved.
 *  .COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author jiyingdabj
 */
public class PrintSoldSeviceSql {

    public static void main(String[] args) throws IOException {
        File preTimeFile = new File("/Users/jiyingda/vs/yfda1");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String sql = "replace into `sold_device` ( `clientId`, `sold`, `dbctime`, `dbutime`) values ( '" + line + "', '1', '2022-09-17 14:24:43', '2022-09-17 14:24:43');";
                System.out.println(sql);
            }
        }
    }
}
