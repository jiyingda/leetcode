/**
 * @(#)Cz.java, 7月 19, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.FileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class Cz {

    public static void main(String[] args) throws IOException {

        // sync_exercise_catalog_online
        //File file1 = new File("/Users/jiyingda/vs/diandu");

        List<String> list = FileReader.readFromVs("初中语文人教点读");


        String ssssss = "以下版本目前仅在“5·3专区”支持，其他模块正在努力筹备中。\n\n小学英语：沪教牛津版\n初中数学：鲁教版、北京课改版、青岛六三、浙教版、冀教版\n初中英语：鲁教版\n初中化学：沪教版、科粤版\n初中生物：人教版、北京课改版、北师大版、苏教版、济南版、冀少版、鲁科版\n初中道德与法治：人教版\n初中历史：人教版\n初中地理：人教版、中图版、湘教版、商务星球版、鲁教版\n高中数学：北师大版、苏教版、湘教版\n高中英语：北师大版、外研版、译林版\n高中物理：教科版、鲁科版、粤教版\n高中化学：鲁科版、苏教版\n高中生物：浙科版、苏教版\n高中地理：人教版、湘教版、中图版、鲁教版\n高中政治：人教版\n高中历史：人教版\n\n如果没找到正在学习的教材，建议先选择较为通用的「人教版」进行练习。\n同时可以前往微信公众号「小猿智能设备」留言告诉我们。";

        int  i = 0;
        for (String line : list) {
            String[] ss = line.split("\t");
            if (ss.length < 9) {
                continue;
            }
            i++;


//        String sql = "INSERT INTO click_read_keypoint_mapping (`name0`,unit1,unitName2,bookVersion3,grade4,semester5,subject6,lessonId7,keypointId8) VALUES ('" +
            String sql = "INSERT INTO click_read_keypoint_mapping (`name`,unit,unitName,bookVersion,grade,semester,subject,lessonId,keypointId) VALUES ('" +
                    ss[4] +"',0,'',1258," + ss[2] + "," +ss[3]+ ",1," + ss[0] + "," + ss[8] +
                    ");";

            System.out.println(sql);
        }
        System.out.println(i);

    }
}
