/**
 * @(#)UserLevel.java, 6月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSON;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingda
 */
public class UserLevel {

    public static void main(String[] args) throws IOException {
        File preTimeFile = new File("/Users/jiyingda/vscode/testStudentLevel");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            int i = 0;

            JSONArray aaaaaa = new JSONArray();
            JSONArray arrag = new JSONArray();
            Map<Integer, Integer> levelMap = new HashMap<>();
            levelMap.put(3, 4);
            levelMap.put(4, 2);
            levelMap.put(5, 6);
            levelMap.put(6, 12);
            while ((line = br.readLine()) != null) {
                String[] array = line.split("\t");
                i++;

                JSONObject obj = new JSONObject();
                obj.put("studentId", Integer.parseInt(array[0]));
                obj.put("gradeId", Integer.parseInt(array[1]));
                obj.put("levelId", levelMap.get(Integer.parseInt(array[3])));
                obj.put("subjectId", 1);
                obj.put("labelId", 1000018);
                obj.put("majorId", 0);
                obj.put("productLineId", 0);
                arrag.add(obj);
                /*if (i % 1000 == 0) {
                    aaaaaa.add(arrag);
                    arrag = new JSONArray();
                }*/
            }

            Files.write(Paths.get("/Users/jiyingda/vscode/job3"), arrag.toJSONString().getBytes());
        }
    }

    public static class A {
        int studentId; // optional
        int gradeId; // optional
        int subjectId; // optional
        int labelId; // optional
        int levelId; // optional
        int majorId; // optional
        int productLineId;
    }

}