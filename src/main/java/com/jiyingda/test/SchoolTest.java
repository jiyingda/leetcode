/**
 * @(#)SchoolTest.java, 9月 08, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingda
 */
public class SchoolTest {

    public static void main(String[] args) throws IOException {
        List<String> sssssss = new ArrayList<>();

        File preTimeFile1 = new File("/Users/jiyingda/vscode/schoolIds123");
        if(preTimeFile1.isFile() && preTimeFile1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile1), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                sssssss.add("&schoolId=" + array[0] + "&phaseId=" + array[1]);
            }


        }


        File preTimeFile = new File("/Users/jiyingda/vscode/userIdsByUserAddress1W.csv");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            int i = 0;
            while ((line = br.readLine()) != null) {
                System.out.println("_debug_user_=" + line + sssssss.get(i));
                i++;
                if (i >= sssssss.size()) {
                    i = 0;
                }
            }


        }
    }
}
