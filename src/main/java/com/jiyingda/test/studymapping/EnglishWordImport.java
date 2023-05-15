/**
 * @(#)EnglishWordImport.java, 4月 28, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.studymapping;

import com.jiyingda.util.FileReader;

import java.util.List;

/**
 * @author jiyingdabj
 */
public class EnglishWordImport {

    public static void main(String[] args) {
        Long a = 1105982837884194817L;
        String s = "一年级作文《阅读让生活更美好》\n\n莎士比亚曾经说过：书是全世界的\n营养品。高尔基曾经说过：书籍是人类\n进步的阶梯。唐代大诗人杜甫有一句名\n言：读书破万卷，下笔如有神。这几句\n话都在告诉我们一个道理；我们的生活\n离不开书。而阅读让生活更美好！\n\n" +
                "阅读让我认识了四大名著中的著名\n" +
                "人物。我领略了诸葛亮在《三国演义》\n" +
                "l$i3$n\n" +
                "中的神机妙算，见识了孙悟空在《西游\n" +
                "记》中的神通广大，感受了林黛玉在《\n" +
                "红楼梦》中的聪慧多愁200\n" +
                "\n" +
                "阅读还能提升我的写作水平呢！大\n" +
                "量阅读让我提高了阅读和理解能力。我\n" +
                "平时读也积累了不少好词好句，在写作\n" +
                "时也能派上大用场，可谓\"读书破万卷\n" +
                "\n" +
                "下笔如有神啊！\"有一次，我给妈妈朗\n" +
                "读我写的作文，妈妈还直夸我进步很大\n" +
                "呢，这都是阅读的功劳！\n" +
                "\n" +
                "阅读还可以治愈心情。有一次，我";
        //System.out.println(s.substring(2));
        String sss = "12345";
        String aaa = sss.substring(4, sss.length() - 1 );
        System.out.println(aaa);
        // List<String> list = FileReader.readFromVs("牛津上海版单词数据");
        /*List<String> list = FileReader.readFromVs("牛津上海版单词数据222");
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

        }*/
    }
}
