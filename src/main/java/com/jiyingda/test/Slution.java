/**
 * @(#)Slution.java, 1月 06, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Slution {

    // 1 2 3 4
    // 1

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = slution(nums);
        for (List<Integer> t : lists) {
            for (Integer i : t) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> slution(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        slution(nums, 0, tempList);
        return list;
    }
    static List<List<Integer>> list = new ArrayList<>();
    public static void slution(int[] nums, int i, List<Integer> tempList) {
        List<Integer> newTempList = new ArrayList<>();
        for (Integer item : tempList) {
            newTempList.add(item);
        }
        list.add(newTempList);
        for (int j = i; j < nums.length; j++) {
            tempList.add(nums[j]);
            slution(nums, j+1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}