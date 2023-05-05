/**
 * @(#)T4.java, 4月 23, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class T4 {

    /*public static void main(String[] args) {
        List<String> list = FileReader.readFromVs("牛津上海版单词数据");
        for (String s : list) {
            String[] ss = s.split("\t");
            int a12 = "核心词汇".equals(ss[12]) ? 1 : 2;
            if (ss[9].contains("'")) {
                //System.out.println(s);
            }
            String s9 = ss[9].replace("'", "\\'");
            String tid = "".equals(ss[0].trim()) ? "0" : ss[0];
            String sql = "insert into `en_keypoint_word` (keypointId, tbUnitId, wordId, word, ordinal, meaning, wordType, audioEnUrl, audioCnUrl, audioBothUrl)" +
                    " VALUES (" +ss[7]+", " +tid+ ", " +ss[8]+ ", '" +s9+ "', " +ss[10]+ ", '" +ss[11] +"', " +a12+ ", '" +ss[14]+ "', '" +ss[15] +"', '" +ss[16]+ "');";
            System.out.println(sql);

        }
    }*/
    public static void main(String[] args) {
        List<String> list = FileReader.readFromVs("点读当前数据");
        List<String> list2 = FileReader.readFromVs("语文点读补充");
        Set<Integer> set = new HashSet<>();
        for (String s : list) {
            String[] ss = s.split("\t");
            set.add(Integer.parseInt(ss[1]));
        }
        for (String s : list2) {
            String[] ss = s.split("\t");
            int keypointId = Integer.parseInt(ss[0]) >= 1000000 ? Integer.parseInt(ss[0]) - 1000000 : Integer.parseInt(ss[0]);
            int lessonId = Integer.parseInt(ss[2]);
            if (set.contains(keypointId)) {
                String sql = "UPDATE click_read_keypoint_mapping set lessonId = " + lessonId + " where keypointId = " + keypointId + ";";
                System.out.println(sql);
            } else {
                String sql = "INSERT INTO click_read_keypoint_mapping (`name`,unit,unitName,bookVersion,grade,semester,subject,lessonId,keypointId) VALUES ('" +
                        ss[1] +"',0,'',4,0,0,1," + lessonId + "," + keypointId +
                        ");";
                System.out.println(sql);

            }
        }
    }
}
