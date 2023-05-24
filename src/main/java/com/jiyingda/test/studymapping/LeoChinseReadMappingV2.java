/**
 * @(#)LeoChinseReadMappingV2.java, 4月 06, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.test.studymapping;

import com.jiyingda.util.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class LeoChinseReadMappingV2 {
    //readClickKey
    public static void main(String[] args) throws IOException {
        List<String> list = FileReader.readFromVs("readClickKey");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : list) {
            String[] ss = s.split("\t");
            map.put(Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));

        }
        //clickNewChinses
        List<String> clickNewChinese = FileReader.readFromVs("clickNewChinses");
        Set<Integer> lll = new HashSet<>();

        Set<Integer> ids = new HashSet<>();

        for (String s : clickNewChinese) {
            String[] ss = s.split("\t");
            if ("#N/A".equals(ss[12])) {
                continue;
            }
            int keypointId = Integer.parseInt(ss[12]);
            int lessonId = Integer.parseInt(ss[0]);
            if (map.containsKey(keypointId)) {
                if (!map.get(keypointId).equals(lessonId)) {
                    if (lll.contains(keypointId)) {
                        //System.out.println(ss[9] + keypointId);

                    } else {
                        lll.add(keypointId);
                        String sql = "UPDATE click_read_keypoint_mapping set `name` = '" + ss[9]+ "',lessonId = "+ lessonId+ " where keypointId = " + keypointId + ";";
                        //System.out.println(sql);
                    }


                }
            } else {
                /*if (ids.contains(keypointId)) {
                    //System.out.println(s);
                } else {
                    ids.add(keypointId);*/
                    String sql = "INSERT INTO click_read_keypoint_mapping (`name`,unit,unitName,bookVersion,grade,semester,subject,lessonId,keypointId) VALUES ('" +
                            ss[9] +"',0,''," + ss[1] + "," + ss[2] + "," +ss[3] + ",1," + lessonId + "," + keypointId +
                            ");";
                    System.out.println(sql);
                //}

            }
        }
    }
}
