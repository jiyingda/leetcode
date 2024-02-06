/**
 * @(#)SortTest.java, 2月 04, 2024.
 * <p>
 * Copyright 2024 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.PrintUtils;

/**
 * @author jiyingdabj
 */
public class SortTest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        // solution(nums);
        //PrintUtils.printArray(nums);
        int a = findKthLargest(nums, 6);
        System.out.println(a);
    }

    private static void solution(int[] nums) {
        solution(nums, 0, nums.length - 1);
    }

    private static void solution(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= target && i < j) {
                j--;
            }
            while (nums[i] <= target && i < j) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[left] = nums[i];
        nums[i] = target;
        solution(nums, left, i - 1);
        solution(nums, i + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int findKthLargest(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[left];
        }
        int target = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= target && i < j) {
                j--;
            }
            while (nums[i] <= target && i < j) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[left] = nums[i];
        nums[i] = target;
        if (i == k) {
           return nums[i];
        } else if (i > k) {
            return findKthLargest(nums, left, i - 1, k);
        } else {
            return findKthLargest(nums, i + 1, right, k);
        }
    }
}
