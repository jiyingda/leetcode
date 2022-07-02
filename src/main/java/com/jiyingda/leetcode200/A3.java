/**
 * @(#)A3.java, 2月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class A3 {


    // 1 ,3 ,5 ,6,7,8
    public static void s(int[] nums) {

    }

    static int min = Integer.MAX_VALUE;
    static List<Integer> minList = new ArrayList<>();
    public static void slution(int[] nums, int len, int m, int current, int left, int right, List<Integer> currentList, int avg) {
        if (m == 1) {
            int t = 0;
            for (int i = left; i <= right; i++) {
                t+=nums[i];
            }
            current = Math.max(current, t);
            //min = Math.min(min, current);
            if (min > current) {
                minList = currentList;
                min = current;
            }
            return;
        }
        if (m <= 0) {
            return;
        }
        int t = 0;
        for (int i = left ; i <= right - m; i++) {
            t += nums[i];
            currentList.add(i);
            current = Math.max(current, t);
            if (current > min) {
                break;
            }
            slution(nums, len, m - 1, current, i + 1, right, currentList, avg);
            currentList.remove(currentList.size() - 1);
        }


    }
}