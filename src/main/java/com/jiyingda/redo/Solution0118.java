/**
 * @(#)Solution0118.java, 1月 18, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-hard/xw1tws/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Solution0118 {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf", t = "cae";
        String a = addBinary(s, t);
        System.out.println(a);

    }

    public static String addBinary(String s, String t) {
        int tLen = t.length();
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        int distinct = 0;
        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        char[] sArray = s.toCharArray();
        int minLen = s.length() + 1;
        int start = 0;
        while (right < s.length()) {
            char c = sArray[right];
            if (!tCount.containsKey(c)) {
                right++;
                continue;
            }
            if (sCount.getOrDefault(c, 0) < tCount.get(c)) {
                distinct++;
            }
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            right++;
            if (distinct == tLen) {
                while (left < right - tLen + 1) {
                    char a = sArray[left];
                    if (!tCount.containsKey(a)) {
                        left++;
                        continue;
                    }
                    if (Objects.equals(sCount.getOrDefault(a, 0), tCount.get(a))) {
                        distinct--;
                    }
                    sCount.put(a, sCount.getOrDefault(a, 0) - 1);
                    if (distinct < tLen) {
                        int l = right - left;
                        if (l < minLen) {
                            minLen = l;
                            start = left;
                        }
                        left++;
                        break;
                    }
                    left++;
                }
            }

        }
        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}