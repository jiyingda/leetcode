/**
 * @(#)T2.java, 8月 11, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class T2 {

    public static void main(String[] args) {

        List<String> qz = FileReader.readFromVs("语文点读online0815");
        List<String> zc = FileReader.readFromVs("语文字词online0815");
        //List<String> mapping = FileReader.readFromVs("keypointMapping");
        List<String> mapping = FileReader.readFromVs("newMapping");

        Map<String, String> map = new HashMap<>();
        for (String m : mapping) {
            String[] ss = m.split("\t");
            String k63 = ss[0];
            String k54 = ss[1];
            //System.out.print(k54 + ",");
            map.put(k63, k54);
        }
        //System.out.println("");
        String sqlClick = "INSERT INTO `click_read_keypoint_mapping` " +
                "(`name`,`unit`,`unitName`,`bookVersion`,`grade`,`semester`,`subject`,`lessonId`,`keypointId`) VALUES ";
        System.out.println(sqlClick);
        for (String c : qz) {
            String[] cc = c.split("\t");
            String kp = cc[9];
            if (map.containsKey(kp)) {
                String kp54 = map.get(kp);
                try {
                    int i54 = Integer.parseInt(kp54);
                    //System.out.println(kp + " -> " + kp54);
                    if ("71282".equals(kp54)) {
                        String sqls = "UPDATE click_read_keypoint_mapping set lessonId = " + cc[8] + " WHERE keypointId = " + kp + ";";
                        System.out.println(sqls);
                    } else {
                        String sql1 = "('" + cc[1] + "','" + cc[2] + "','" + cc[3] + "','" + cc[4] + "','" + cc[5] + "','" + cc[6] + "','" + cc[7] + "','" + cc[8] + "','" + kp54 + "'), ";
                        System.out.println(sql1);
                    }

                } catch (Exception e) {

                }
            }
        }

        String p = "INSERT INTO `leo_chinese_keypoint_mapping` (`name`,`bookVersion`,`grade`,`semester`,`leoKeypointId`,`keypointId`) VALUES ";
        System.out.println(p);
        for (String s : zc) {
            String[] ss = s.split("\t");
            String kp = ss[6];
            if (map.containsKey(kp)) {
                String kp54 = map.get(kp);
                try {
                    int i54 = Integer.parseInt(kp54);
                    String sqlT = "('" + ss[1] + "','" + ss[2] + "','" + ss[3] + "','" + ss[4] + "','" + ss[5] + "','" + kp54 + "'),";
                    System.out.println(sqlT);
                } catch (Exception e) {

                }
            }



        }




    }
}
