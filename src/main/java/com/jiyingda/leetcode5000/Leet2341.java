/**
 * @(#)Leet2341.java, 2月 16, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 *
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 *
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,2,1,3,2,2]
 * 输出：[3,1]
 * 解释：
 * nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
 * nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
 * nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
 * 无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,0]
 * 解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
 * 无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0,1]
 * 解释：无法形成数对，nums 中剩下 1 个数字。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 *
 * @author jiyingdabj
 */
public class Leet2341 {

    public static void main(String[] args) {
        int[] aa = numberOfPairs(new int[]{1, 1});
        System.out.println(aa[0] + "   " + aa[1]);
    }


    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int a = 0;
        for (int num : nums) {
            Integer val = map.get(num);
            if (val == null) {
                map.put(num, 1);
            } else {
                a++;
                if (val - 1 == 0) {
                    map.remove(num);
                } else {
                    map.put(num, val - 1);
                }
            }
        }

        return new int[]{a, map.size()};
    }
}
