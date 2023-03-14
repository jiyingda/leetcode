/**
 * @(#)FileWriter.java, 3月 14, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * @author jiyingdabj
 */
public class FileWriter {

    private static final String VS_ROOT_DIR = "/Users/jiyingda/vs/";

    public static void write(String path, String s) {
        try {
            Files.write(Paths.get(VS_ROOT_DIR + path), s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("write file error", e);
        }
    }

    public static void write(String path, Collection<String> c) {
        try {
            Files.write(Paths.get(VS_ROOT_DIR + path), c);
        } catch (IOException e) {
            throw new RuntimeException("write file error", e);
        }
    }
}
