package com.jiyingda.leetcode50;

import java.util.HashMap;
import java.util.Map;

public class Leet3 {
    public static void main(String... args){

        System.out.println(lengthOfLongestSubstring("abaabbcbb"));

    }



    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;

        }
        char[] array = s.toCharArray();
        int left = 0;
        int right = 1;
        int max = 1;
        int currentLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(array[left], 0);
        while (left < right && right < array.length) {
            if (map.containsKey(array[right])) {
                int ll = map.get(array[right]);
                max = Math.max(max, currentLen);
                while (left <= ll) {
                    map.remove(array[left]);
                    left++;
                    currentLen--;
                }
                map.put(array[right], right);
                right++;
                currentLen++;
            } else {
                map.put(array[right], right);
                right++;
                currentLen++;
            }
        }
        return Math.max(max, currentLen);
    }
}
