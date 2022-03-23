/**
 * @(#)Leet1400.java, 3月 03, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode0222;

/**
 * @author jiyingdabj
 */
public class Leet1400 {

    public static void main(String[] args) {
        /**
         * '40212'
         * '40939'
         * '42031'
         * '42177'
         * '45866'
         * '45961'
         * '46569'
         * '46571'
         * '46601'
         * '46780'
         * '46801'
         * '46806'
         * '46883'
         * '46897'
         * '46899'
         * '46913'
         * '46921'
         * '46947'
         * '46952'
         * '47078'
         * '47080'
         * '47134'
         * '47135'
         * '47137'
         * '47209'
         * '47434'
         * '47476'
         * '47499'
         * '47505'
         * '47718'
         * '47720'
         */
        //"qlkzenwmmnpkopu"
        //"ibzkwaxxaggkiwjbeysz"
        //15
        String s = "'40212'\n" +
                "'40939'\n" +
                "'42031'\n" +
                "'42177'\n" +
                "'45866'\n" +
                "'45961'\n" +
                "'46569'\n" +
                "'46571'\n" +
                "'46601'\n" +
                "'46780'\n" +
                "'46801'\n" +
                "'46806'\n" +
                "'46883'\n" +
                "'46897'\n" +
                "'46899'\n" +
                "'46913'\n" +
                "'46921'\n" +
                "'46947'\n" +
                "'46952'\n" +
                "'47078'\n" +
                "'47080'\n" +
                "'47134'\n" +
                "'47135'\n" +
                "'47137'\n" +
                "'47209'\n" +
                "'47434'\n" +
                "'47476'\n" +
                "'47499'\n" +
                "'47505'\n" +
                "'47718'\n" +
                "'47720'";
        String[] ss = s.split("\n");
        String sql = "update question set currentDifficulty = ";
        String sqq = " where id = ";
        int i = 0;
        for (String sssss : ss) {
            i++;
            System.out.println(sql  + (i % 9) + sqq +sssss + ";");
        }




        boolean a = canConstruct("ibzkwaxxaggkiwjbeysz", 15);
        System.out.println(a);
    }

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] array = new int[26];
        for (char ch : s.toCharArray()) {
            array[ch - 'a']++;
        }
        int a = 0;
        int b = 0;
        for (int i : array) {
            if (i < 1) {
                continue;
            }
            if (i % 2 == 1) {
                a++;
            }
            b += i / 2;
        }
        return a <= k && a + b * 2 >= k;
    }
}
