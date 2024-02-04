/**
 * @(#)Solution387.java, 7月 11, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *  
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] ch = new int[26];
        for (char c : array) {
            int idx = c - 'a';
            ch[idx]++;
        }
        for (int i = 0; i < array.length; i++) {
            int idx = array[i] - 'a';
            if (ch[idx] == 1) {
                return i;
            }
        }

        return -1;
    }
}
