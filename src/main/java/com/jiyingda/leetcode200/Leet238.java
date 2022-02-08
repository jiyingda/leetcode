/**
 * @(#)Leet238.java, 2月 08, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

/**
 * @author jiyingdabj
 */
public class Leet238 {

    public static void main(String[] args) {
        Leet238 leet238 = new Leet238();
        int[] nums = new int[]{-1,1,0,-3,3};
        leet238.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;

    }
}
