/**
 * @(#)Leet2427.java, 4月 05, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

/**
 * @author jiyingda
 */
public class Leet2427 {
    public static void main(String[] args) {

    }

    public int commonFactors(int a, int b) {
        int k = Math.min(a, b);
        int c = 0;
        for (int i = 1; i <= k; i++) {
            if (a % i == 0 && b % i == 0) {
                c++;
            }
        }

        return c;
    }
}