/**
 * @(#)Leet942.java, 4月 12, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 只包含字符 "I" 或 "D"
 *
 * https://leetcode.cn/problems/di-string-match/
 *
 * @author jiyingda
 */
public class Leet942 {
    public static void main(String[] args) {

    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        char[] arrays = s.toCharArray();
        int[] num = new int[n + 1];
        int left = 0;
        int right = n;
        for (int i = 0; i < n; i++) {
            if (arrays[i] == 'I') {
                num[i] = left;
                left++;

            } else {
                num[i] = right;
                right--;
            }
        }
        num[arrays.length] = left;
        return num;
    }
}