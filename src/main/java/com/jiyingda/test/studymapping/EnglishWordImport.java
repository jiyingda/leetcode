/**
 * @(#)EnglishWordImport.java, 4月 28, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.test.studymapping;

import com.jiyingda.util.FileReader;

import java.util.List;

/**
 * @author jiyingdabj
 */
public class EnglishWordImport {

    private static int getWordType(String c) {
        if ("核心词汇".equals(c)) {
            return 1;
        }
        if ("其他词汇".equals(c)) {
            return 2;
        }
        if ("必会词汇".equals(c)) {
            return 3;
        }
        throw new RuntimeException();


    }

    public static void main(String[] args) {
        // List<String> list = FileReader.readFromVs("牛津上海版单词数据");
        // List<String> list = FileReader.readFromVs("牛津上海版单词数据222");
        //List<String> list = FileReader.readFromVs("沪教牛津三年级起点单词导入");
        List<String> list = FileReader.readFromVs("外研社版三起点英语单词导入");
        for (String s : list) {
            String[] ss = s.split("\t");
            int a12 = getWordType(ss[12].trim());
            if (ss[9].contains("'")) {
                //System.out.println(s);
            }
            String s9 = ss[9].replace("'", "\\'");
            String tid = "".equals(ss[0].trim()) ? "0" : ss[0];
            String sql = "insert into `en_keypoint_word` (keypointId, tbUnitId, wordId, word, ordinal, meaning, wordType, audioEnUrl, audioCnUrl, audioBothUrl)" +
                    " VALUES (" +ss[7]+", " +tid+ ", " +ss[8]+ ", '" +s9+ "', " +ss[10]+ ", '" +ss[11] +"', " +a12+ ", '" +ss[14]+ "', '" +ss[15] +"', '" +ss[16]+ "');";
            System.out.println(sql);

        }
    }
}
