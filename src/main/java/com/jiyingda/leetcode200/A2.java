/**
 * @(#)A2.java, 2月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

/**
 * @author jiyingda
 */
public class A2 {
    // 1 , 2, 3 ,4

    public static void main(String[] args) {
        int[] nusm = new int[]{1,2,3,-2,2};
        int k = slution(nusm);
        System.out.print(k);
    }


    public static int slution(int[] nums) {
        int max = 1;
        int min = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = max * nums[i];
                if (min < 0) {
                    min = min * nums[i];
                }
            } else if (nums[i] < 0) {
                int t = max * nums[i];
                if (min < 0) {
                    max = min * nums[i];
                } else {
                    max = 1;
                }
                min = t;
            }
        }
        return Math.max(max, min);


    }
}