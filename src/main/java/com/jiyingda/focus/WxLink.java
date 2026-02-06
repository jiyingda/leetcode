/**
 * @(#)Test123.java, 7月 17, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.focus;

import com.jiyingda.util.FileReader;
import com.jiyingda.util.FileWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class WxLink {

    public static void main2(String[] args) {
        // 查询2026-01-18北京天气
    }

    public static void main(String[] args) {
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
        FileWriter.write("wx0205.csv", out);


    }


}
