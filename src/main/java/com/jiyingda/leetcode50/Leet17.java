/**
 * @(#)Leet17.java, 1月 26, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet17 {

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    static Map<Character, char[]> map = new HashMap<Character, char[]>() {
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };


    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;

        }
        char[] array = digits.toCharArray();

        letterCombinations(array, 0, new StringBuilder(), list);
        return list;
    }

    public static void letterCombinations(char[] array, int i, StringBuilder sb, List<String> list) {
        if (i >= array.length) {
            list.add(sb.toString());
            return;
        }
        char[] a = map.get(array[i]);
        for (int k = 0; k < a.length; k++) {
            sb.append(a[k]);
            letterCombinations(array, i + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
