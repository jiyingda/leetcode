package com.jiyingda.leetcode;

import java.util.*;

/**
 * @author jiyingda.
 * @date 2019/8/13.
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet22 {
    Map<Integer, Set<String>> map = new HashMap<>();

    public static void main(String[] args){
        Leet22 leet22 = new Leet22();

        List<String> list = leet22.generateParenthesis(4);
        List<String> list2 = leet22.generateParenthesis(7);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        if(map.containsKey(n)){
            return new ArrayList<>(map.get(n));
        }
        create(n);
        return new ArrayList<>(map.get(n));
    }

    public void create(int n){
        if(!map.containsKey(1)){
            Set<String> list = new HashSet<>();
            list.add("()");
            map.put(1, list);
        }
        for(int i = 2; i <= n; i++){
            if(!map.containsKey(i)){
                getDT(i);
                getM(i);

            }
        }
    }

    private void getDT(int n){
        Set<String> setn1 = map.get(n - 1);
        Set<String> setn = new HashSet<>();
        for(String s : setn1){
            setn.add("(" + s + ")");
        }
        map.put(n,setn);
    }

    private void getM(int n){
        for(int i = 1; i < n; i++){
            Set<String> iset = map.get(i);
            Set<String> nset = map.get(n-i);
            Set<String> set = map.get(n);
            for(String s : iset){
                for(String ss : nset){
                    set.add(s + ss);
                }
            }
        }
    }
}
