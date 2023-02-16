/**
 * @(#)Leet2006.java, 2月 09, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class Leet2006 {

    public static void main(String[] args) {
        Leet2006 leet2006 = new Leet2006();
        int[] nums = new int[]{1,2,2,1};
        int a = leet2006.countKDifference(nums, 1);
        System.out.println(a);
    }

    public int countKDifference(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                map.get(n).add(i);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(i);
                map.put(n, t);
            }
        }
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int a = n + k;
            int b = n - k;
            r += count(map.get(a), i);
            r += count(map.get(b), i);
        }
        return r;
    }

    private int count(List<Integer> list, int i) {
        if (list == null || list.size() < 1) {
            return 0;
        }
        int p = 0;
        for (Integer j : list) {
            if (j <= i) {
                p++;
            }
        }
        return list.size() - p;
    }
}
