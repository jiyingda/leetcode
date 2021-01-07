package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @author jiyingda.
 * @date 2020/11/26.
 */
public class core {

    public static void main(String[] args) throws IOException {


        //11
        //2
        File file1 = new File("D:\\notePadFiles\\core.txt");
        if(file1.isFile() && file1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = null;

            JSONArray array = new JSONArray();
            int i = 0;
            while ((lineTxt = br.readLine()) != null) {

                String[] ss = lineTxt.split("\t");

                String sql = "update interactive_resume set ";
                if(!"".equals(ss[1])){
                    sql += "introduce = '" + ss[1] + "'";
                }


                sql += " where account_id = " + ss[0] + ";";
                System.out.println(sql);

            }

        }

    }
}
