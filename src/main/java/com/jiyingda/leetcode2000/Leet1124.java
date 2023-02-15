/**
 * @(#)Leet1124.java, 2月 14, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 *
 * 输入：hours = [6,6,6]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 * https://leetcode.cn/problems/longest-well-performing-interval/
 *
 * @author jiyingdabj
 */
public class Leet1124 {

    public static void main(String[] args) {
        int[] hours = new int[]{9,9,6,0,6,6,9,9,9};
        int a = longestWPI(hours);
        System.out.println(a);
    }

    public static int longestWPI(int[] hours) {
        int len = hours.length;
        int max = 0;
        int s = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                max = Math.max(max, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    max = Math.max(max, i - map.get(s - 1) + 1);
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }

        }

        return max;
    }
}
