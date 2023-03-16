/**
 * @(#)Leet409.java, 3月 01, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输出:1
 * 示例 3：
 *
 * 输入:s = "aaaaaccc"
 * 输出:7
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 *
 * https://leetcode.cn/problems/longest-palindrome/
 *
 * @author jiyingda
 */
public class Leet409 {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char ch : array) {
            int v = map.getOrDefault(ch, 0);
            if (v == 0) {
                map.put(ch, 1);
            } else if (v == 1) {
                map.remove(ch);
                count += 2;
            } else {
                map.put(ch, v - 1);
                count += 2;
            }
        }
        if (map.size() > 0) {
            count++;
        }
        return count;

    }
}