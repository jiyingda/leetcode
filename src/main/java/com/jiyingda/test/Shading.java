/**
 * @(#)Shading.java, 5月 07, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.Arrays;

/**
 * @author jiyingda
 */
public class Shading {
    public static void main(String[] args) throws InterruptedException {
        long teacherId = 12345;
        System.out.println(40413073% 128);



        /*Shading shading = new Shading();
        int a = shading.search(new int[]{1, 3, 5, 7, 9}, 7);
        System.out.println(a);*/
    }

    private int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return search(nums, target, left, mid - 1);
        } else {
            return search(nums, target, mid + 1, right);
        }
    }
}