package com.jiyingda.leetcode50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 * @date 2019/8/16
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet28 {
    public static void main(String[] args){
        System.out.println(strStr("hello", "ll"));;
    }


    public static int strStr(String haystack, String needle) {
        return search(haystack, needle);
    }

    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    static int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1]; // ①
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)) {
                maxLength++; // ②
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }

    static int search(String text, String pattern) {
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatchLengths[count - 1];
            }
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
            if (count == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }
}
