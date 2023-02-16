/**
 * @(#)Leet487.java, 2月 23, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet487 {

    public static void main(String[] args) {
        Leet487 leet487 = new Leet487();
        int[] nums = new int[]{0,1};
        leet487.findMaxConsecutiveOnes(nums);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                list.add(0);
                i++;
            } else {
                int current = 0;
                while (i < nums.length && nums[i] == 1) {
                    i++;
                    current++;
                }
                list.add(current);
            }
        }
        int max = 0;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                int c = 1;
                if (i != 0) {
                    c += list.get(i - 1);
                }
                if (i < list.size() - 1) {
                    c  +=  list.get(i + 1);
                }
                max = Math.max(max, c);
            } else {
                max = Math.max(max, list.get(i));
            }
        }
        return max;

    }
}