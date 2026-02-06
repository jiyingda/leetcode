/**
 * @(#)Test0227.java, 2月 27, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class Test0227 {
    public static void main(String[] args) {
        int a = lengthOfLIS(new int[]{7,7,7});
        System.out.print(a);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int mm = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
            mm = Math.max(mm, max);
        }
        return mm;

    }
}