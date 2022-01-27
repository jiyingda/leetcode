package com.jiyingda.leetcode50;

import java.util.*;

/**
 * @author jiyingda.
 * @date 2020/3/26.
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet49 {


    public static void main(String[] args){
        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {""};
        List<List<String>> re = groupAnagrams(strs);
        System.out.println(re);
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
                    Arrays.sort(ch);
            String ss = String.valueOf(ch);
            if (map.containsKey(ss)) {
                map.get(ss).add(s);
            } else {
                List<String> sss = new ArrayList<>();
                sss.add(s);
                map.put(ss, sss);
            }
        }
        return new ArrayList<>(map.values());
    }






    public static List<List<String>> groupAnagrams2(String[] strs) {


        List<List<String>> reList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();



        for(String s : strs){
            char[] chs = s.toCharArray();

                Arrays.sort(chs);
                String sss = String.valueOf(chs);
                if(map.containsKey(sss)){
                    map.get(sss).add(s);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(s);
                    map.put(sss, tmp);
                }


        }

        /*for(Map.Entry<String, List<String>> en : map.entrySet()){
            reList.add(en.getValue());
        }*/
        return new ArrayList<>(map.values());

    }
}
