/**
 * @(#)S2.java, 3月 18, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.Js100;

import java.util.Arrays;

/**
 * @author jiyingda
 */
public class S2 {
    public static void main(String[] args) {
        int k = maximizeGreatness(new int[]{1,2,3,4});
        System.out.print(k);

    }

    public static int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        int j = 1;
        int n = 0;
        while (j < len && i < len) {
            if (nums[j] > nums[i]) {
                i++;
                j++;
                n++;
            } else {
                j++;
            }
        }
        return n;
    }
}