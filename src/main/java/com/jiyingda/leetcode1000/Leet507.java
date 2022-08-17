/**
 * @(#)Leet507.java, 3月 21, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

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
