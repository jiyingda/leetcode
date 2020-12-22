package com.jiyingda.leetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/22 16:36
 */
public class Leet131 {
    public static void main(String[] args) {
        List<List<String>> list = partition("aba");
        for(List<String> ls : list){
            for(String l : ls){
                System.out.print(l + " ,");
            }
            System.out.print("\n");
        }

    }

    public static List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();
        List<List<String>> list = new ArrayList<>();
        partition(arr, 0, arr.length-1, new ArrayList<>(), list);
        return list;

    }

    public static void partition(char[] arr, int left, int right,List<String> current, List<List<String>> list){
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++){
            sb.append(arr[i]);
            if(isHuiwen(arr, left, i)){
                if(i == right){
                    current.add(sb.toString());
                    list.add(new ArrayList<>(current));
                    current.remove(current.size()-1);
                } else {
                    current.add(sb.toString());
                    partition(arr, i+1, right,current, list);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    public static boolean isHuiwen(char[] arr, int left, int right){
        if(left > right){
            return false;
        }
        if(left == right){
            return true;
        }
        while (left < right) {
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
