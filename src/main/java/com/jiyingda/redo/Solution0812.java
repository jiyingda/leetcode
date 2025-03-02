/**
 * @(#)Soultion0812.java, 8月 12, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import com.jiyingda.util.PrintUtils;

import java.util.PriorityQueue;

/**
 * @author jiyingda
 */
public class Solution0812 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1};
        int[] res = maxSlidingWindow(nums, 1);
        PrintUtils.printArray(res);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e2[1] - e1[1]);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{i, nums[i]});
        }
        res[j] = queue.peek()[1];
        j++;
        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
            while (queue.peek()[0] <= i - k) {
                queue.poll();
            }
            int[] a = queue.peek();
            res[j] = a[1];
            j++;

        }

        return res;
    }
}