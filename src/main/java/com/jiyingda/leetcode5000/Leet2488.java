/**
 * @(#)Leet2488.java, 3月 16, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.leetcode5000;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 *
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 *
 * 注意：
 *
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 *
 * https://leetcode.cn/problems/count-subarrays-with-median-k/
 *
 * @author jiyingdabj
 */
public class Leet2488 {

    public static void main(String[] args) {
        int k = countSubarrays(new int[]{5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14}, 6);
        System.out.println(k);

    }

    public static int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIndex = i;
                break;
            }
        }
        int ans = 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        counts.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if (i < kIndex) {
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            } else {
                int prev0 = counts.getOrDefault(sum, 0);
                int prev1 = counts.getOrDefault(sum - 1, 0);
                ans += prev0 + prev1;
            }
        }
        return ans;

    }

    public static int sign(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;
    }
}