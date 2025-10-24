/**
 * @(#)FileWriter.java, 3月 14, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * @author jiyingdabj
 */
public class FileWriter {

    private static final String VS_ROOT_DIR = "/Users/jiyingdabj/vs/";

    public static void write(String path, String s) {
        try {
            Path p = Paths.get(VS_ROOT_DIR + path);
            Files.createDirectories(p.getParent());
            Files.write(p, s.getBytes(StandardCharsets.UTF_8));
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

    public static void writePts(String path, Collection<String> c) {
        try {
            Files.write(Paths.get(VS_ROOT_DIR + "pts_online/" + path), c);
        } catch (IOException e) {
            throw new RuntimeException("write file error", e);
        }
    }
}
