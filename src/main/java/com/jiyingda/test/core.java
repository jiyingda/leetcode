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
        //22333555
        File file1 = new File("/Users/jiyingda/work/2");
        if(file1.isFile() && file1.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt = null;
            int i = 0;
            while ((lineTxt = br.readLine()) != null) {


                System.out.print(lineTxt + ",");

            }

        }

    }

}
