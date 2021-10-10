/**
 * @(#)QkSort.java, 10月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class QkSort {


    public static void main(String[] args) {
        int[] nums = new int[]{2,4,5,3,1,6,7};
        sort(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }

    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int base = nums[left];
        int l = left;
        int r = right;
        while (l != r) {
            while (l < r && nums[r] >= base) {
                r--;
            }
            while (l < r && nums[l] <= base) {
                l++;
            }
            if (l < r) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            }
        }

        nums[left] = nums[l];
        nums[l] = base;

        sort(nums, left, l - 1);
        sort(nums, l + 1, right);

    }
}