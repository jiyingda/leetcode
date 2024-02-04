/**
 * @(#)Leet392.java, 3月 22, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

/**
 * @author jiyingdabj
 */
public class Leet392 {

    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < ss.length && j < tt.length) {
            if (ss[i] == tt[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }
}
