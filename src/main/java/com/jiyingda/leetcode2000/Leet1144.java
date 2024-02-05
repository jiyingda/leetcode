/**
 * @(#)Leet1144.java, 2月 27, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM . Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 *
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 *
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 *
 * @author jiyingda
 */
public class Leet1144 {
    public static void main(String[] args) {
        int a = movesToMakeZigzag(new int[]{1,2,3});
        System.out.print(a);

    }

    public static int movesToMakeZigzag(int[] nums) {
        return Math.min(movesToMakeZigzag(nums, true), movesToMakeZigzag(nums, false));
    }

    public static int movesToMakeZigzag(int[] nums, boolean flag) {
        int a = 0;
        int pre = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (flag) {
                if (pre > nums[j]) {
                    pre = nums[j];
                } else {
                    a += nums[j] - pre + 1;
                    pre = pre - 1;
                }
                flag = false;
            } else {
                if (pre < nums[j]) {
                    pre = nums[j];
                } else {
                    a += pre - nums[j] + 1;
                    pre = nums[j];
                }
                flag = true;
            }
        }
        return a;
    }
}