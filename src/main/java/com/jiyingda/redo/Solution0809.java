/**
 * @(#)Solution0809.java, 8月 09, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingda
 */
public class Solution0809 {
    public static void main(String[] args) {
        // nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
        int r = fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1, 2}, new int[]{0,2});
        System.out.println(r);
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int t = -(k + i);
                set.put(t, set.getOrDefault(t, 0) + 1);
            }
        }
        int r = 0;
        for (int k : nums3) {
            for (int i : nums4) {
                int t = k + i;
                if (set.containsKey(t)) {
                    r = r + set.get(t);
                }
            }
        }
        return r;
    }

}