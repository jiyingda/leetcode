/**
 * @(#)Leet1133.java, 2月 23, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class Leet1133 {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (int num : nums) {
            if (map.getOrDefault(num, 0) > 1) {
                continue;
            }
            max = Math.max(max, num);
        }

        return max;
    }
}
