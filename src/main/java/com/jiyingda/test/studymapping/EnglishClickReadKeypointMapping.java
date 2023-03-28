/**
 * @(#)EnglishClickReadKeypointMapping.java, 3月 27, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.studymapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;

import java.io.IOException;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class EnglishClickReadKeypointMapping {

    public static void main(String[] args) throws IOException {

        // sync_exercise_catalog_online
        //File file1 = new File("/Users/jiyingda/vs/diandu");

        List<String> list = FileReader.readFromVs("online英语点读mapping");
        for (String line : list) {
            String[] ss = line.split("\t");
//        String sql = "INSERT INTO click_read_keypoint_mapping (`name0`,unit1,unitName2,bookVersion3,grade4,semester5,subject6,lessonId7,keypointId8) VALUES ('" +
            String sql = "INSERT INTO click_read_keypoint_mapping (`name`,unit,unitName,bookVersion,grade,semester,subject,lessonId,keypointId) VALUES ('" +
                    ss[4] +"'," + ss[3] + ",'','" + ss[8] + "'," + ss[9] + "," + ss[10] + ",3," + ss[6] + "," + ss[0] +
                    ");";

            System.out.println(sql);
        }

    }
}
