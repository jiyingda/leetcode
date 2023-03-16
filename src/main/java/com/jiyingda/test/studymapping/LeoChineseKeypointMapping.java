package com.jiyingda.test.studymapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jiyingda.
 * @date 2020/11/26.
 */
public class LeoChineseKeypointMapping {

    public static void main(String[] args) throws IOException {
        // sync_exercise_catalog_online
        //File file1 = new File("/Users/jiyingda/vs/diandu");
        File file1 = new File("/Users/jiyingda/vs/sync_exercise_catalog_online");
        if(file1.isFile() && file1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = null;

            while ((lineTxt = br.readLine()) != null) {

                String[] ss = lineTxt.split("\t");
                String com = ss[10];
                JSONArray array = JSONArray.parseArray(com);
                long lessonId = 0L;
                long keypointId = 0L;

                for (int i = 0; i< array.size(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    try {
                        if (obj.getInteger("type") == 7) {
                            keypointId = obj.getInteger("keypointId");
                        }
                        if (obj.getInteger("type") == 0) {
                            lessonId = obj.getInteger("keypointId");
                        }
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }

                }
                if (lessonId > 0 && keypointId > 0) {
                    String sql = "INSERT INTO leo_chinese_keypoint_mapping (`name`,bookVersion,grade,semester,leoKeypointId,keypointId) VALUES ('" +
                            ss[0] +"'," + ss[3] + "," + ss[4] + "," +ss[5] + "," + lessonId + "," + keypointId +
                            ");";

                    System.out.println(sql);

                } else {

                }

            }

        }

    }

}
