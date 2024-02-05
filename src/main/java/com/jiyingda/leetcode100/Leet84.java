/**
 * @(#)Leet84.java, 1月 27, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 *  
 *
 * 提示：
 *
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Leet84 {

    public static void main(String[] args) {
        int[] h = new int[]{2, 4};
        System.out.println(largestRectangleArea(h));
    }

    private static int max = 0;

    public static int largestRectangleArea(int[] heights) {
        max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i< heights.length; i++) {
            if (map.containsKey(heights[i])) {
                map.get(heights[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(heights[i], list);
            }
        }
        List<List<Integer>> list = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).collect(Collectors.toList());
        int top = heights[list.get(list.size() - 1).get(0)];
        largestRectangleArea(heights, 0, heights.length - 1, list, 0, top);
        return max;
    }

    public static void largestRectangleArea(int[] heights, int left, int right, List<List<Integer>> list, int m, int top) {
        if (m >= list.size()) {
            return;
        }
        int min = heights[list.get(m).get(0)];
        if (max >= (right - left + 1) * top) {
            return;
        }
        max = Math.max(max, (right - left + 1) * min);
        if (heights[left] == min) {
            left++;
        }
        if (heights[right] == min) {
            right--;
        }
        for (int ss : list.get(m)) {
            if (left <= ss && ss <= right) {
                largestRectangleArea(heights, left, ss - 1, list, m + 1, top);
                left = ss + 1;
            }
        }
        if (right >= left) {
            if (heights[left] == min) {
                left++;
            }
            if (heights[right] == min) {
                right--;
            }
            largestRectangleArea(heights, left, right, list, m + 1, top);
        }
    }
}