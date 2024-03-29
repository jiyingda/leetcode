/**
 * @(#)Leet693.java, 6月 23, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

/**
 * @author jiyingdabj
 */
public class Leet693 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(7));
    }


    public static boolean hasAlternatingBits(int n) {
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for (int i = 1; i < ch.length; i++) {
            if (ch[i-1] == ch[i]) {
                return false;
            }
        }
        return true;
    }
}
