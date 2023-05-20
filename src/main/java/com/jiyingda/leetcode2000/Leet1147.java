/**
 * @(#)Leet1147.java, 4月 12, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * 你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
 *
 * subtexti 是 非空 字符串
 * 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 * 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 * 返回k可能最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 * 示例 2：
 *
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 * 示例 3：
 *
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 1000
 * text 仅由小写英文字符组成
 *
 * https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/
 *
 * @author jiyingda
 */
public class Leet1147 {
    public static void main(String[] args) {
        int k = longestDecomposition("antaprezatepzapreanta");
        System.out.println(k);

    }

    public static int longestDecomposition(String text) {
        int i = 0, j = text.length() - 1;
        int right = text.length() - 1;
        char[] array = text.toCharArray();
        int num = 0;
        while (i <= j) {
            while (array[i] != array[j]) {
                j--;
            }
            int d = right - j;
            if (check(array, i, j, d)) {
                if (i == j) {
                    num += 1;
                } else {
                    num += 2;
                }
                i = i + d + 1;
                j--;
                right = j;
            } else {
                j--;
            }
        }
        return num;
    }

    private static boolean check(char[] array, int i, int j, int d) {
        while (d >= 0) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j++;
            d--;
        }
        return true;
    }
}