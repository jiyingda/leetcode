/**
 * @(#)Leet1685.java, 3月 18, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * @author jiyingdabj
 */
public class Leet1685 {


    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] r = new int[nums.length];
        int left = 0; int right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i] - nums[0];
        }
        r[0] = right;
        for (int i = 1; i < nums.length; i++) {
            left = i * (nums[i] - nums[i - 1]) + left;
            right = right - (nums.length - i) * (nums[i] - nums[i - 1]);
            r[i] = left + right;
        }
        return r;
    }
}
