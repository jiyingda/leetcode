/**
 * @(#)Test3333.java, 2月 07, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class Test3333 {

    public static void main(String[] args) {
        Test3333 test3333 = new Test3333();
        int[] nums = new int[]{1,2,3,4};
        test3333.rotate(nums, 2);
        Integer.reverse(1);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //k = k % len;
        int i = 0;
        int temp = nums[0];
        int j = 0;
        while (i < len) {
            int idx = (j + k) % len;
            int t = nums[idx];
            nums[idx] = temp;
            temp = t;
            j = idx;
            i++;
        }
    }
}