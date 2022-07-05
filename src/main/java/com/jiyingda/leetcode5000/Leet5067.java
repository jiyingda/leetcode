package com.jiyingda.leetcode5000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiyingda
 * @date 2019/9/8
 *
 * 输入： "aaaba"
 * 输出： 8
 * 解释：
 * 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
 * "aaa" 出现 1 次。
 * "aa" 出现 2 次。
 * "a" 出现 4 次。
 * "b" 出现 1 次。
 * 所以答案是 1 + 2 + 4 + 1 = 8。
 */
public class Leet5067 {

    public static void main(String[] args){

    }

    public static int countLetters(String S) {
        Map<String, Integer> map = new HashMap<>();

        char[] arr = S.toCharArray();
        char tmp = arr[0];
        int n = 0;
        int m = 0;
        for(int i = 0; i < arr.length; i++){
            if(tmp == arr[i]){
                m++;
            }

            for(int j = i; j < arr.length; j++){
                setToMap(map, S.substring(i,j));
            }
        }
        //TODO
        return 0;

    }

    public static void setToMap(Map<String, Integer> map, String a){
        if(map.containsKey(a)){
            map.put(a, map.get(a) + 1);
        }else {
            map.put(a, 1);
        }
    }
}
