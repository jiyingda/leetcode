/**
 * @(#)Test54.java, 7月 26, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;
import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class BookVersionConfigToSql {

    public static void main(String[] args) {
        String s = FileReader.readFromVsV2("bookversion-config.json");
        JSONObject jsonObject = JSONObject.parseObject(s);
        jsonObject.entrySet().forEach(e -> {
            JSONObject v = jsonObject.getJSONObject(e.getKey());
            JSONArray array = v.getJSONArray("config");
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                int bookVersion = obj.getInteger("bookVersion");
                String name = obj.getString("name");
                String grades = obj.getString("grades");
                String exerciseTypes = obj.getString("exerciseTypes");
                int subjectId = obj.getInteger("subjectId");
                int courseId = obj.getInteger("courseId");
                String weight = obj.getString("weight");
                String volumeList = obj.getString("volumeList");
                String sql = "insert into bookversion_config (bookVersion, name, grades, exerciseTypes, subjectId, courseId, weight, volumeList, version, status) values ("
                        + bookVersion + ", '" + name + "', '" + grades + "', '" + exerciseTypes + "', " + subjectId + ", " + courseId + ", '" + weight + "', '"
                        + volumeList + "', '" +e.getKey()+ "', 2);";
                System.out.println(sql);

                if (bookVersion == 1112 || bookVersion == 1124) {
                    String update = "update bookversion_config set exerciseTypes = '" + exerciseTypes + "' where bookVersion = " +bookVersion + ";";
                    System.out.println(update);
                }
            }

        });

    }
}
