/**
 * @(#)Leet1017.java, 4月 06, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * @author jiyingda
 */
public class Leet1017 {
    public static void main(String[] args) {
        String s = baseNeg2(1);
        System.out.print(s);

    }

    public static String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int m = n % (-2);
            sb.append(Math.abs(m));
            if (m < 0) {
                n = n / (-2) + 1;
            } else {
                n = n / (-2);
            }
        }
        return sb.reverse().toString();

    }
}