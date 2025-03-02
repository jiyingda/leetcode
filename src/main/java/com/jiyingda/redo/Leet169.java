/**
 * @(#)Leet169.java, 2月 25, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * @author jiyingda
 */
public class Leet169 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int a = majorityElement(nums);
        System.out.println(a);

    }

    public static int majorityElement(int[] nums) {
        int r = nums[0];
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == r) {
                n++;
            } else {
                if (n > 0) {
                    n--;
                } else {
                    r = nums[i];
                    n = 1;
                }
            }
        }
        return r;
    }


}