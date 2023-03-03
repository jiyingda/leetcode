package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jiyingda.
 * @date 2020/11/26.
 */
public class core {

    public static void main(String[] args) throws IOException {


        //11
        //22333555
        File file1 = new File("/Users/jiyingda/vs/diandu");
        if(file1.isFile() && file1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = null;

            while ((lineTxt = br.readLine()) != null) {

                String[] ss = lineTxt.split("\t");
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
