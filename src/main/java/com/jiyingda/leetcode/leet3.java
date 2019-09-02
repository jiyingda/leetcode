package com.jiyingda.leetcode;

public class leet3 {
    public static void main(String... args){

        System.out.println(lengthOfLongestSubstring("sbcsafgr"));

    }



    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;

        }
        char[] sss = s.toCharArray();
        int start = 0;
        int end = 1;
        int length = 1;
        for(int i = 1; i < sss.length; i++){

            for(int j = start; j < end; j++){

                if(sss[i] == sss[j]){
                    if((end - start) > length){
                        length = end - start;
                    }
                    start = j + 1;
                    end = i;
                    break;
                }
            }
            end++;
        }
        if((end - start) > length){
            length = end - start;
        }
        return length;
    }
}
