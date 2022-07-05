/**
 * @(#)Leet674.java, 3月 24, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

/**
 * @author jiyingdabj
 */
public class Leet674 {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int current = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 1;
            }
        }

        return max;
    }
}
