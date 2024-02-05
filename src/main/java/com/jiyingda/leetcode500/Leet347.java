/**
 * @(#)Leet347.java, 2月 07, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet347 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        Leet347 leet347 = new Leet347();
        System.out.println(leet347.topKFrequent(nums, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Element> que = new PriorityQueue<>(k, Comparator.comparing(Element::getCount));
        map.forEach((n, v) -> {
            if (que.size() >= k) {
                if (que.peek().count < v) {
                    que.poll();
                    que.offer(new Element(n, v));
                }
            } else {
                que.offer(new Element(n, v));
            }

        });
        int[] re = new int[k];
        int i = 0;
        while (i < k) {
            re[i] = que.poll().n;
            i++;
        }
        return re;
    }

    class Element {
        int n;
        int count;

        public int getCount() {
            return count;
        }

        public Element(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
