/**
 * @(#)LeoChineseMappingV2.java, 4月 06, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.studymapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class LeoChineseMappingV2 {

    public static void main(String[] args) throws IOException {
        List<String> list = FileReader.readFromVs("leoMappingLod");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : list) {
            String[] ss = s.split("\t");
            map.put(Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));

        }
        List<String> unit777 = FileReader.readFromVs("unit777");
        Set<Integer> lll = new HashSet<>();
        Set<Integer> ids = new HashSet<>();

        for (String s : unit777) {
            String[] ss = s.split("\t");
            if ("#N/A".equals(ss[17])) {
                continue;
            }
            int keypointId = Integer.parseInt(ss[17]);
            if (map.containsKey(keypointId)) {
                if (!map.get(keypointId).equals(Integer.parseInt(ss[0]))) {
                    if (lll.contains(keypointId)) {
                        //System.out.println(ss[1] + keypointId);
                    } else {
                        lll.add(keypointId);
                        //System.out.println(s);
                        String sql = "UPDATE leo_chinese_keypoint_mapping SET `name` = '" + ss[1] + "',leoKeypointId = " + ss[0] + " where keypointId = " +keypointId + ";";
                        //System.out.println(sql);
                    }

                }
            } else {
                if (ids.contains(keypointId)) {
                    //System.out.println(s);

                } else {
                    ids.add(keypointId);
                    String sql = "INSERT INTO leo_chinese_keypoint_mapping (`name`,bookVersion,grade,semester,leoKeypointId,keypointId) VALUES ('" +
                            ss[1] +"'," + ss[6] + "," + ss[7] + "," +ss[8] + "," + ss[0] + "," + keypointId +
                            ");";
                    System.out.println(sql);
                }
            }
        }




    }
}
