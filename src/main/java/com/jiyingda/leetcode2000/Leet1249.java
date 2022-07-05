/**
 * @(#)Leet1249.java, 3月 22, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.Stack;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *  
 *
 * 示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 *
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 可能是 '('、')' 或英文小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet1249 {

    public static void main(String[] args) {
        Leet1249 leet1249 = new Leet1249();
        String s = leet1249.minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(s);
    }

    public String minRemoveToMakeValid(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ')') {
                if (stack.isEmpty()) {
                    sb.setCharAt(i, '_');
                } else {
                    stack.pop();
                }
            } else if (array[i] == '(') {
                stack.add(i);
            }
        }
        while (!stack.isEmpty()) {
            int i = stack.pop();
            sb.setCharAt(i, '_');
        }
        return sb.toString().replaceAll("_", "");
    }

}
