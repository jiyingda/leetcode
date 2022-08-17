/**
 * @(#)Team.java, 5月 08, 2021.
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
import java.nio.charset.StandardCharsets;

/**
 * @author jiyingda
 */
public class Team {


    public static void main(String[] args) throws IOException {
        File preTimeFile = new File("/Users/jiyingda/vscode/teamid");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] array = line.split(" ");
                i++;
                if (i == 500) {
                    System.out.print("\n\n");
                    i = 0;
                }
                System.out.print(array[5]);

            }
        }
    }
}