/**
 * @(#)Leet219.java, 2月 09, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class Leet219 {

    public static void main(String[] args) {
        int j = 0;
        for (int i = 1993; i <= 2022; i++) {
            System.out.println(i);
            j++;
        }
        System.out.println(j);
        /*Leet219 leet219 = new Leet219();
        int[] nums = new int[]{1,0,1,1};
        boolean f = leet219.containsNearbyDuplicate(nums, 1);
        System.out.println(f);*/
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
