package com.jiyingda.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2019/9/2.
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet32 {

    public static void main(String[] args){
        System.out.println(longestValidParentheses("()()()"));;
    }

    static class Count{
        int a;
        int b;

        public Count(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static int longestValidParentheses(String s) {
        List<Count> reList = new ArrayList<>();
        char[] array = s.toCharArray();
        int len = s.length();
        reList.add(new Count(0,-2));
        int i =1;
        while (i < len){
            char a = array[i-1];
            char b = array[i];
            if(check(a, b)){
                int p = i-1;
                int q = i;
                boolean flag;

                do {
                    Count cc = doo(p, q, array, len);

                    Count tt = reList.get(reList.size() - 1);
                    if (tt.b + 1 == cc.a) {
                        tt.b = cc.b;
                        flag = true;
                        p = tt.a;
                        q = tt.b;
                    }else if(tt.b == cc.b){
                        flag = false;
                    }else {
                        flag = false;
                        reList.add(cc);
                    }
                }while (flag);


                i = q;
            }
            i++;
        }



        return 0;
    }




    public static Count doo(int p, int j, char[] array, int len){
        while (p >=0 && j < len && check(array[p], array[j])){
            j++;
            p--;
        }
        return new Count(p+1,j-1);
    }


    public static boolean check(char a, char b){
        return a == '(' && b == ')';
    }
}
