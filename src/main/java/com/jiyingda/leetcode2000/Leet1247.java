/**
 * @(#)Leet1247.java, 3月 23, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * @author jiyingdabj
 */
public class Leet1247 {


    public int minimumSwap(String s1, String s2) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < ss1.length; i++) {
            if (ss1[i] != ss2[i]) {
                if (ss1[i] == 'x') {
                    x++;
                } else {
                    y++;
                }
            }
        }
        int res = 0;
        res += x / 2 + y / 2;
        int mod1 = x % 2;
        int mod2 = y % 2;

        if(mod1 != mod2)
            return -1;

        return res + mod1 * 2;
    }
}
