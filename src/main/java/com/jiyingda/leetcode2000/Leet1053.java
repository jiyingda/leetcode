/**
 * @(#)Leet1053.java, 4月 03, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 *
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 *
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 *
 * @author jiyingda
 */
public class Leet1053 {
    public static void main(String[] args) {
        prevPermOpt1(new int[]{3,1,1,3});

    }

    public static int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int j = len - 1;
        int i = j - 1;
        while (i >= 0) {
            if (arr[j] >= arr[i]) {
                i--;
                j--;
            } else {
                while (j < len && arr[j] < arr[i]) {
                    j++;
                }
                j--;
                while (j > i && arr[j] == arr[j - 1]) {
                    j--;
                }
                int c = arr[j];
                arr[j] = arr[i];
                arr[i] = c;
                return arr;
            }
        }
        return arr;
    }
}