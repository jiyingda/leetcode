/**
 * @(#)Leet1641.java, 3月 29, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.leetcode2000;

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 *
 * 输入：n = 33
 * 输出：66045
 *
 *
 * 提示：
 *
 * 1 <= n <= 50
 *
 * https://leetcode.cn/problems/count-sorted-vowel-strings/description/
 *
 * @author jiyingdabj
 */
public class Leet1641 {
    public static void main(String[] args) {
        int a = countVowelStrings(33);
        System.out.println(a);
    }

    public static int countVowelStrings(int n) {
        int[] a = new int[n];
        int[] e = new int[n];
        int[] i = new int[n];
        int[] o = new int[n];
        int[] u = new int[n];
        a[0] = 1;
        e[0] = 1;
        i[0] = 1;
        o[0] = 1;
        u[0] = 1;

        for (int j = 1; j < n; j++) {
            a[j] = a[j - 1] + e[j - 1] + i[j - 1] + o[j - 1] + u[j - 1];
            e[j] = e[j - 1] + i[j - 1] + o[j - 1] + u[j - 1];
            i[j] = i[j - 1] + o[j - 1] + u[j - 1];
            o[j] = o[j - 1] + u[j - 1];
            u[j] = u[j - 1];
        }
        return a[n - 1] + e[n - 1] +  i[n - 1] + o[n - 1] + u[n - 1];
    }
}
