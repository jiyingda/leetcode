/**
 * @(#)Leet1213.java, 2月 23, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Leet1213 {
    /**
     * [280,289,424,425,429,447,654,661,696,703,739,792,828,845,855,914,928,996,1001,1033,1106,1109,1131,1257,1355,1360,1377,1381,1403,1429,1447,1455,1493,1494,1509,1542,1591,1611,1651,1669,1684,1714,1742,1786,1843,1863,1867,1973,1977,1995]
     * [91,119,179,198,201,228,292,329,364,433,468,517,535,543,551,552,605,618,656,658,709,723,745,811,844,854,856,867,912,957,969,1002,1013,1015,1252,1267,1278,1318,1359,1495,1535,1571,1659,1741,1786,1795,1896,1965,1969,1973]
     * [62,142,172,195,259,267,285,326,353,356,367,389,413,462,483,535,545,603,651,660,678,748,795,804,827,889,890,966,982,994,1012,1018,1120,1238,1278,1314,1334,1357,1419,1433,1479,1495,1587,1616,1687,1869,1877,1893,1904,1916]
     * @param args
     */

    public static void main(String[] args) {


        String s = "{\"content\":\"I have a book.\",\"sentenceType\":1,\"avatarUrl\":\"https://leo-test.fbcontent.cn/leo-english/spoken-question-audio/dialogue-avatar/avatar202104012.png\",\"scene\":\"Dialogue1\",\"pictureUrl\":\"https://leo-test.fbcontent.cn/leo-english/spoken-question-audio/dialogue-picture/picture11202104011.png\"}";
        JSONObject obj = JSONObject.parseObject(s);
        System.out.println(obj.getString("content"));




        int[] arr1 = new int[]{1,2,424,425,429,447,654,661,696,703,739,792,828,845,855,914,928,996,1001,1033,1106,1109,1131,1257,1355,1360,1377,1381,1403,1429,1447,1455,1493,1494,1509,1542,1591,1611,1651,1669,1684,1714,1742,1786,1843,1863,1867,1973,1977,1995};
        int[] arr2 = new int[]{2,119,179,198,201,228,292,329,364,433,468,517,535,543,551,552,605,618,656,658,709,723,745,811,844,854,856,867,912,957,969,1002,1013,1015,1252,1267,1278,1318,1359,1495,1535,1571,1659,1741,1786,1795,1896,1965,1969,1973};
        int[] arr3 = new int[]{2,142,172,195,259,267,285,326,353,356,367,389,413,462,483,535,545,603,651,660,678,748,795,804,827,889,890,966,982,994,1012,1018,1120,1238,1278,1314,1334,1357,1419,1433,1479,1495,1587,1616,1687,1869,1877,1893,1904,1916};
        arraysIntersection(arr1, arr2, arr3);
    }


    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int j = 0;
        int k = 0;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                list.add(arr1[i]);
                j++;
                k++;
                i++;
                continue;
            }
            while (j < arr2.length && arr1[i] > arr2[j]) {
                j++;
            }
            while (k < arr3.length && arr1[i] > arr3[k]) {
                k++;
            }
            while (i < arr1.length && j < arr2.length && k < arr3.length && (arr1[i] < arr2[j] || arr1[i] < arr3[k])) {
                i++;
            }
        }
        return list;

    }
}
