/**
 * @(#)m1705.java, 3月 11, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM . Use is subject to license terms.
 */
package com.jiyingda.ms;

import com.jiyingda.util.PrintUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 *
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 *
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 *
 * 输入: ["A","A"]
 *
 * 输出: []
 * 提示：
 *
 * array.length <= 100000
 *
 * https://leetcode.cn/problems/find-longest-subarray-lcci/
 *
 * @author jiyingda
 */
public class M1705 {
    public static void main(String[] args) {
        M1705 m1705 = new M1705();
        //String[] array = new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] array = new String[]{"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        String[] ss = m1705.findLongestSubarray(array);
        PrintUtils.printArray(ss);

    }

    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        indices.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (indices.containsKey(sum)) {
                int firstIndex = indices.get(sum);
                if (i - firstIndex > maxLength) {
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            } else {
                indices.put(sum, i);
            }
        }
        if (maxLength == 0) {
            return new String[0];
        }
        String[] ans = new String[maxLength];
        System.arraycopy(array, startIndex, ans, 0, maxLength);
        return ans;

    }
}