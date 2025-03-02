/**
 * @(#)Soultion0817.java, 8月 17, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author jiyingda
 */
public class Soultion0817 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = t.toCharArray();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = s.length() - 1;
        char[] cList = s.toCharArray();
        int len = cList.length;
        while (left < right) {
            int mun = map.getOrDefault(cList[left], 0);
            if (mun > 0) {
                map.put(cList[left], mun - 1);
            } else {
                left++;
            }

        }

        return "";
    }
}