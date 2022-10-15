/**
 * @(#)Leet415.java, 2月 06, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

/**
 * @author jiyingda
 */
public class Leet415 {

    public static void main(String[] args) {
        System.out.print(addStrings("11", "123"));;
    }

    public static String addStrings(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int[] re = new int[len];
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = re.length - 1;
        int p = 0;
        while (k >= 0) {
            if (i >= 0) {
                p += Integer.valueOf("" + ch1[i]);
            }
            if (j >= 0) {
                p += Integer.valueOf("" + ch2[j]);
            }
            if (p > 9) {
                re[k] = p - 10;
                p = 1;
            } else {
                re[k] = p;
                p = 0;
            }
            i--;
            j--;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        if (p > 0) {
            sb.append(p);
        }
        for (int e : re) {
            sb.append(e);
        }
        return sb.toString();
    }
}