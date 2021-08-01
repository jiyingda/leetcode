/**
 * @(#)Leet557.java, 8月 01, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Leet557 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] ss = s.split(" ");
        if (ss.length < 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (String sss : ss) {
            sb.append(String.valueOf(reverseString(sss.toCharArray()))).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static char[] reverseString(char[] s) {
        char a;
        int len = s.length;
        int ll = len/2;
        for (int i = 0; i< ll; i++) {
            a = s[i];
            s[i] = s[len-i - 1];
            s[len-i-1] = a;
        }
        return s;
    }
}