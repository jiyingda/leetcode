/**
 * @(#)Leet1864.java, 2月 19, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet1863 {

    public static void main(String[] args) {
        Leet1863 leet1863 = new Leet1863();
        int[] nums = new int[]{3,4,5,6,7,8};
        int a = leet1863.subsetXORSum(nums);
        System.out.print(a);
    }


    public int subsetXORSum(int[] nums) {
        subsetXORSum(nums, new ArrayList<>(), 0);
        int all = 0;
        for (List<Integer> s : list) {
            if (s.size() < 1) {
                continue;
            }
            int temp = s.get(0);
            for (int i = 1; i < s.size(); i++) {
                temp = temp ^ s.get(i);
            }
            all += temp;
        }

        return all;
    }

    private List<List<Integer>> list = new ArrayList<>();

    public void subsetXORSum(int[] nums, List<Integer> current, int i) {

        list.add(new ArrayList<>(current));
        for (int j = i; j < nums.length; j++) {
            current.add(nums[j]);
            subsetXORSum(nums, current, j + 1);
            current.remove(current.size() - 1);
        }
    }
}