/**
 * @(#)Leet0302.java, 3月 02, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author jiyingda
 */
public class Leet0302 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.containsKey(m)) {
                return new int[]{map.get(m), i};
            }
            map.put(m, i);
        }
        return new int[]{-1, -1};
    }
}