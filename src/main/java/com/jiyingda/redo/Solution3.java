/**
 * @(#)Solution3.java, 6月 30, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingdabj
 */
public class Solution3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] ss = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < ss.length) {
            if (!map.containsKey(ss[j])) {
                map.put(ss[j], j);
                j++;
            } else {
                max = Math.max(max, j - i);
                int k = map.get(ss[j]);
                while (i <= k) {
                    map.remove(ss[i]);
                    i++;
                }
            }
        }
        if (i < j) {
            max = Math.max(max, j - i);
        }
        return max;
    }
}
