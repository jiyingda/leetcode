/**
 * @(#)FileReader.java, 3月 14, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class FileReader {

    private static final String VS_ROOT_DIR = "/Users/jiyingda/vs/";

    public static List<String> readFromVs(String filePath) {
        return read(VS_ROOT_DIR + filePath);
    }

    public static List<String> read(String filePath) {
        File file = new File(filePath);
        if (!file.isFile()) {
            throw new RuntimeException("not file");
        }
        if (!file.exists()) {
            throw new RuntimeException("file not exists");
        }
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("read file error", e);
        }
        return list;
    }
}
