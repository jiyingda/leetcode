/**
 * @(#)TestOOM.java, 9月 05, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.PrintUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiyingdabj
 */
public class TestOOM {


    public static void main(String[] args) {
        int a = searchPosition(new int[]{1,3,5,7,9}, 0);
        System.out.println(a);


    }

    public static int searchPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target && (left == 0 || nums[left - 1] <= target)) {
            if (left == 0) {
                return 0;
            }
            if (nums[left] == target) {
                return left;
            }
            return left - 1;
        }
        return -1;
    }
}

