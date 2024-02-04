/**
 * @(#)Leet1100.java, 2月 24, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiyingda
 */
public class Leet1100 {

    /**
     * "havefunonleetcode"
     * 5
     * @param args
     */
    public static void main(String[] args) {
        Leet1100 leet1100 = new Leet1100();
        leet1100.numKLenSubstrNoRepeats("abce", 5);
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = 0;
        int num = 0;
        Set<Character> set = new HashSet<>();
        while (j < array.length) {
            while (set.contains(array[j])) {
                set.remove(array[i]);
                i++;
            }
            if (j - i< k) {
                set.add(array[j]);
                j++;
            }
            if (j - i == k) {
                num++;
                set.remove(array[i]);
                i++;
            }

        }
        return num;

    }
}