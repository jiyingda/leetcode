/**
 * @(#)Test333.java, 1月 26, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingdabj
 */
public class Test333 {

    public static void main(String[] args) {
        //removeDuplicates(new int[] {0, 0, 1, 2, 2, 2});
        System.out.println(strStr("hellolliii", "lll"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i;
                int k = 0;
                while (k < needle.length()) {
                    if (haystack.charAt(j) == needle.charAt(k)) {
                        j++;
                        k++;
                    } else {
                        break;
                    }
                }
                if (k == needle.length()) {
                    return i;
                }


            }
        }
        return -1;
    }


    public static int removeDuplicates(int[] nums) {
        int pre = nums[0];
        int f = 1;
        int i = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == pre) {
                i++;
            }
            if (i < nums.length && nums[i] != pre) {
                swap(nums, f, i);
                pre = nums[f];
                f++;
                i++;

            }
        }
        return f;

    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        nums[a] = nums[b];

    }
}
