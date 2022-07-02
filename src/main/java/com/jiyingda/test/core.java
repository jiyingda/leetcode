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
        File file1 = new File("/Users/jiyingda/vs/volume");
        if(file1.isFile() && file1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = null;

            JSONArray array = new JSONArray();
            int i = 0;
            Set<Long> historyIdset = new HashSet<>();
            while ((lineTxt = br.readLine()) != null) {

                String[] ss = lineTxt.split("\t");
                long userId = Long.parseLong(ss[0]);
                long historyId = Long.parseLong(ss[1]);
                int volume = Integer.parseInt(ss[2]);

                if (historyIdset.contains(historyId)) {

                } else {
                    historyIdset.add(historyId);
                    String sql = "update common_exercise_history set volume = " + volume + " where firstCommitId = " + historyId + " and userId = " + userId + " and createdTime > 1650988800000;";
                    //String sql = "select * from  common_exercise_history where id = " + historyId + " and userId = " + userId + " and createdTime > 1650988800000;";

                    System.out.println(sql);
                }



            }

        }

    }

}
