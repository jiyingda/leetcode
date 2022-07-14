/**
 * @(#)Leet567.java, 7月 12, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet567 {

    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int[] ch = new int[26];
        for (char c : s1.toCharArray()) {
            ch[c - 'a']++;
        }
        char[] array = s2.toCharArray();
        int i = 0, j = 0;
        while (j < array.length) {
            char c = array[j];
            if (ch[c - 'a'] > 0) {
                ch[c - 'a']--;
                j++;
            } else {
                if (j - i >= len) {
                    return true;
                }
                i++;
            }

        }

        return false;
    }
}
