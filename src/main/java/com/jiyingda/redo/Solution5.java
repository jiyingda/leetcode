/**
 * @(#)Solution5.java, 6月 30, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String s = solution5.longestPalindrome("a");
        System.out.println(s);
    }


    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return s;
        }
        int[] max = new int[]{0, 0};
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int[] a = palindromic(array, i, i);
            if (a[1] - a[0] >= max[1] - max[0]) {
                max = a;
            }
            if (i + 1 < array.length) {
                int[] b = palindromic(array, i, i + 1);
                if (b[1] - b[0] >= max[1] - max[0]) {
                    max = b;
                }
            }
        }

        return s.substring(max[0], max[1] + 1);
    }

    public int[] palindromic(char[] array, int i, int j) {
        while (i >= 0 && j < array.length) {
            if (array[i] != array[j]) {
                return new int[]{i + 1, j - 1};
            } else {
                i--;
                j++;
            }
        }
        return new int[]{i + 1, j - 1};
    }
}
