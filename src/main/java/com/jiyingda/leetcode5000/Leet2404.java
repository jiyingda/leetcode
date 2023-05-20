/**
 * @(#)Leet2404.java, 4月 13, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 *
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 *
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * 示例 3：
 *
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 105
 *
 * https://leetcode.cn/problems/most-frequent-even-element/
 *
 * @author jiyingda
 */
public class Leet2404 {
    public static void main(String[] args) {

    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (n % 2 == 0) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        if (map.isEmpty()) {
            return -1;
        }
        int max = 0;
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                idx = entry.getKey();
            } else if (entry.getValue() == max) {
                if (idx > entry.getKey()) {
                    idx = entry.getKey();
                }
            }
        }

        return idx;
    }
}