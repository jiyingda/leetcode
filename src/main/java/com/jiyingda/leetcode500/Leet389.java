/**
 * @(#)Leet389.java, 3月 01, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM . Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * https://leetcode.cn/problems/find-the-difference/description/
 *
 * @author jiyingda
 */
public class Leet389 {
    public static void main(String[] args) {
        char c = findTheDifference("abcd", "abcde");
        System.out.print(c);

    }

    public static char findTheDifference(String s, String t) {
        int[] ch = new int[26];
        for (char c : s.toCharArray()) {
            ch[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            ch[c - 'a'] -= 1;
            if (ch[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';

    }
}