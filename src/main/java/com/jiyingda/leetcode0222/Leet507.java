/**
 * @(#)Leet507.java, 3月 21, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode0222;

/**
 * @author jiyingdabj
 */
public class Leet507 {
    public static void main(String[] args) {
        boolean f = checkPerfectNumber(1);
        System.out.println(f);
    }


    public static boolean checkPerfectNumber(int num) {
        int all = 1;
        int max = num;
        for (int i = 2; i < max; i++) {
            if (num % i == 0) {
                all = all + i + (num / i);
                max = num / i;
                if (max > num) {
                    return false;
                }
            }
        }
        return all == num;

    }
}
