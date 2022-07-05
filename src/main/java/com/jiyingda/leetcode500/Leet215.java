/**
 * @(#)Leet215.java, 2月 06, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author jiyingda
 */
public class Leet215 {

    public static void main(String[] args) {
        Leet215 leet215 = new Leet215();
        System.out.print(leet215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }


    public int findKthLargest(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int[] nn = new int[set.size()];
        int i = 0;
        for (int s : set) {
            nn[i] = s;
            i++;
        }
        return search(nn, 0, nn.length - 1, k - 1);
    }

    public int search(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int l = left;
        int r = right;
        swap(nums, new Random().nextInt(right - left + 1) + left, right);
        int base = nums[r];
        while (l < r) {
            while (l < r && nums[l] >= base) {
                l++;
            }
            while (l < r && nums[r] <= base) {
                r--;
            }
            if (l < r) {
                swap(nums, l ,r);
            }

        }
        nums[right] = nums[r];
        nums[r] = base;
        if (r == k) {
            return nums[r];
        }
        if (r > k) {
            return search(nums, left, r - 1, k);
        }
        return search(nums, r + 1, right, k);
    }

    public void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}