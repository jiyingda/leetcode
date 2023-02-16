/**
 * @(#)Offer2007.java, 2月 15, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingda
 */
public class Offer2007 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) || len - i < 2) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (sum > 0) {
                    break;
                }
                int k = len - 1;
                while (j < k) {
                    if (sum + nums[k] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                    if (sum + nums[k] < 0) {
                        break;
                    }
                    k--;
                }
            }
        }
        return list;

    }
}