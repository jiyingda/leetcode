package com.jiyingda.leetcode;

import org.apache.commons.collections.MapUtils;

import java.util.*;

/**
 * @author jiyingda.
 * @date 2020/1/13.
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet30 {

    public static void main(String[] args){
        //String s = "barfoothefoobarman";
        String s = "wordgoodgoodgoodbestword";
        //String[] wo = {"foo","bar"};
        String[] wo = {"word","good","best","word"};
        List<Integer> list = findSubstring(s, wo);
        System.out.println(list);

    }


    public static List<Integer> findSubstring(String s, String[] words) {
        if(words.length < 1){
            return Collections.emptyList();
        }
        int a = words[0].length();
        int b = words.length;
        int l = a * b;
        if(s.length() < l){
            return Collections.emptyList();
        }
        List<Integer> relist = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String tmp : words){
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp)+ 1);
            } else {
                map.put(tmp, 1);

            }
        }

        for(int i = 0; i < s.length(); i++){
            if(i + l > s.length()){
                break;
            }
            String str = s.substring(i, i+ l);
            if(isT(str, a, map)){
                relist.add(i);
            }
        }



        return relist;
    }


    public static boolean isT(String s, int a, Map<String, Integer> map){
        int l =s.length();
        Map<String, Integer> maps = new HashMap<>(map.size());
        for(int i = 0; i < l; i = i+a){
            String tmp = s.substring(i, i + a);
            int b = map.getOrDefault(tmp, 0);
            if(b > 0){
                int c = maps.getOrDefault(tmp, 0);
                if(c  < b){
                    maps.put(tmp, c + 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
