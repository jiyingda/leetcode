/**
 * @(#)Solution081003.java, 8月 10, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * @author jiyingda
 */
public class Solution081003 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int a = firstMissingPositive(nums);
        System.out.println(a);
    }

    public static int firstMissingPositive(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int k : nums) {
            if (k >= 0 && k <= nums.length) {
                count[k]++;
            }
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                return i;
            }
        }
        return count.length;

    }
}