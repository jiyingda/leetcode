package com.jiyingda.leetcode50;

public class Leet14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return "";
        }
        if(strs.length < 1){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder re = new StringBuilder();
        for(int j = 0; j < strs[0].length(); j++){
            char c0 = strs[0].charAt(j);

            for(int i = 1; i < strs.length; i++){
                if(strs[i].length() > j && c0 == strs[i].charAt(j)){

                }else{
                    return re.toString();
                }
            }
            re.append(c0);
        }
        return re.toString();
    }

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));;

    }
}
