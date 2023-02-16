/**
 * @(#)Testpre.java, 3月 19, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jiyingda
 */
public class Testpre {

    public static void main(String[] args) throws IOException {
        File file1 = new File("/Users/jiyingda/work/2");
        if(file1.isFile() && file1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = null;
            int i = 0;
            while ((lineTxt = br.readLine()) != null) {


                System.out.print(lineTxt + ",");

            }

        }
    }
}