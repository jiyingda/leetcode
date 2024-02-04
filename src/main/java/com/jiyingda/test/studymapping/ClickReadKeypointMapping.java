package com.jiyingda.test.studymapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingda.
 * @date 2020/11/26.
 */
public class ClickReadKeypointMapping {

    public static void main(String[] args) throws IOException {
        String ssss = "675\t4\t6\t1\t673\t2\t1.211E+12\t1.211E+18\t[]\t小站\t82\t1\t71718\n" +
                "699\t4\t6\t1\t697\t1\t1.211E+12\t1.211E+18\t[118]\t好的故事\t118\t1\t71824\n" +
                "700\t4\t6\t1\t697\t1\t1.211E+12\t1.211E+18\t[121]\t我的伯父鲁迅先生\t121\t1\t71826\n" +
                "701\t4\t6\t1\t697\t1\t1.211E+12\t1.211E+18\t[125]\t有的人——纪念鲁迅有感\t125\t1\t71828";
        String[] abc = ssss.split("\n");
        for (String sss : abc) {
            // String sss = "638\t6\t1\t草原\t2\t1\t71650";
            String[] ss = sss.split("\t");
            if (ss.length > 6) {
                String sql = "INSERT INTO click_read_keypoint_mapping (`name`,unit,unitName,bookVersion,grade,semester,subject,lessonId,keypointId) VALUES ('" +
                        ss[3] +"'," + 0 + ",'" + "'," + 0 + "," + ss[1] + "," +ss[2] + ",1," + ss[0] + "," + ss[12] +
                        ");";
                System.out.println(sql);
            } else {
                // System.out.println(sss);
            }

        }

    }

    public static void main2(String[] args) throws IOException {

        // sync_exercise_catalog_online
        //File file1 = new File("/Users/jiyingda/vs/diandu");
        Set<Long> set = new HashSet<>();

        List<String> list = FileReader.readFromVs("sync_exercise_catalog_online");

        for (String line : list) {
            String[] ss = line.split("\t");
            String com = ss[10];
            JSONArray array = JSONArray.parseArray(com);
            long lessonId = 0L;
            long keypointId= 0L;

            for (int i = 0; i< array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                try {
                    if (obj.getInteger("type") == 7) {
                        keypointId = obj.getInteger("keypointId");
                    }
                    if (obj.getInteger("type") == 8) {
                        lessonId = obj.getInteger("keypointId");
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                }

            }
            if (!set.contains(keypointId)) {
                set.add(keypointId);
                if (lessonId > 0 && keypointId > 0) {
                    String sql = "INSERT INTO click_read_keypoint_mapping (`name`,unit,unitName,bookVersion,grade,semester,subject,lessonId,keypointId) VALUES ('" +
                            ss[0] +"'," + ss[1] + ",'" + ss[2] + "'," + ss[3] + "," + ss[4] + "," +ss[5] + ",1," + lessonId + "," + keypointId +
                            ");";

                    System.out.println(sql);

                } else {

                }
            }

        }

    }

}
