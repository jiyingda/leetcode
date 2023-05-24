/**
 * @(#)Leet416.java, 5月 24, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 *
 */
package com.jiyingda.leetcode500;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 
 * @author jiyingdabj
 */
public class Leet416 {

    public static void main(String[] args) {
        Leet416 leet416 = new Leet416();
        int[] nums = new int[]{1,1,1,1};
        boolean f = leet416.canPartition(nums);
        System.out.println(f);

    }

    public boolean canPartition(int[] nums) {
        int all = Arrays.stream(nums).sum();
        if (all % 2 == 1) {
            return false;
        }
        int mid = all / 2;
        Arrays.sort(nums);
        return canPartition(nums, 0, 0, mid);
    }

    public boolean canPartition(int[] nums, int i, int current, int sum) {
        if (current == sum) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }

        int pre = -1;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == pre) {
                continue;
            }
            pre = nums[j];
            if (current > sum) {
               continue;
            }
            boolean f = canPartition(nums, j + 1, current + nums[j], sum);
            if (f) {
                return true;
            }
        }
        return false;
    }
}
