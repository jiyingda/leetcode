/**
 * @(#)Leet680.java, 4月 11, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 *
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 *
 * https://leetcode.cn/problems/valid-palindrome-ii/
 *
 * @author jiyingda
 */
public class Leet680 {
    public static void main(String[] args) {
        Leet680 leet680 = new Leet680();
        boolean f = leet680.validPalindrome("abc");
        System.out.print(f);

    }

    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] != array[j]) {
                boolean f = validPalindromeInner(array, i + 1, j);
                if (f) {
                    return true;
                }
                return validPalindromeInner(array, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindromeInner(char[] array, int l, int r) {
        while (l < r) {
            if (array[l] != array[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}