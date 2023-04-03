/**
 * @(#)Leet2367.java, 4月 01, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

/**
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 *
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums 严格 递增
 *
 * https://leetcode.cn/problems/number-of-arithmetic-triplets/
 *
 * @author jiyingda
 */
public class Leet2367 {
    public static void main(String[] args) {
        int n = arithmeticTriplets(new int[]{6,14,15,26,31,36,38,41,42,45}, 5);
        System.out.print(n);

    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int c = 0;
        int  i = 0;
        int j = 1;
        while (i < j && j < nums.length) {
            int d = nums[j] - nums[i];
            if (d == diff) {
                int q = j + 1;
                while (q < nums.length) {
                    int dddd = nums[q] - nums[j];
                    if (dddd == diff) {
                        c++;
                    }
                    if (dddd >= diff) {
                        break;
                    }
                    q++;
                }
                i++;
                j++;
            } else if (d < diff) {
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }
        }
        return c;
    }
}