/**
 * @(#)Solution0121.java, 1月 21, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * @author jiyingda
 */
public class Solution0121 {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] != val) {
                i++;
            }
            if (nums[i] == val) {
                while (i < j && nums[j] == val) {
                    j--;
                }
                int c = nums[i];
                nums[i] = nums[j];
                nums[j] = c;
            }
        }
        return nums[i] == val ? i : i + 1;
    }
}