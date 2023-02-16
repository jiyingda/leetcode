/**
 * @(#)Leet384.java, 2月 03, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import com.jiyingda.util.PrintUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 *
 * 示例 1：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 104 次 reset 和 shuffle
 * @author jiyingdabj
 */
public class Leet384 {

    private int[] nums;
    private int len;
    private Random random = new Random();

    public Leet384(int[] nums) {
        len = nums.length;
        this.nums = nums;

    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] shuffleNums = Arrays.copyOf(nums, len);

        for (int i = 0; i < len; i++) {
            int j = random.nextInt(len);
            swap(shuffleNums, i, j);
        }
        return shuffleNums;
    }

    private void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }

    public static void main(String[] args) {
        Leet384 leet384 = new Leet384(new int[]{1,2,3});
        int[] shuff = leet384.shuffle();
        //PrintUtils.printArray(shuff);
        int[] ss = leet384.reset();
        PrintUtils.printArray(ss);

    }
}
