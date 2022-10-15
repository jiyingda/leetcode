/**
 * @(#)Leet1864.java, 2月 19, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
        int[] nums = new int[]{5,1,6};
        leet1863.subsetXORSum(nums);
    }


    public int subsetXORSum(int[] nums) {
        //for (int i = 0; i < nums.length; i++) {
            subsetXORSum(nums, new ArrayList<>(), 0);
        //}

        System.out.print(list);
        return 0;
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