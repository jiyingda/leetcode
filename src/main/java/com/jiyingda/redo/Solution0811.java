/**
 * @(#)Solution0811.java, 8月 11, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author jiyingda
 */
public class Solution0811 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int a = longestConsecutive(nums);
        System.out.println(a);

    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int max = 0;
        for (int num : nums) {
            if (map.get(num) <= 0) {
                continue;
            }
            map.put(num, 1);
            int count = 1;
            int k = num - 1;
            while (map.containsKey(k)) {
                map.put(k, 0);
                count++;
                k--;
            }
            k = num + 1;
            while (map.containsKey(k)) {
                map.put(k, 0);
                count++;
                k++;
            }
            map.put(num, 0);
            max = Math.max(max, count);
        }
        return max;

    }
}