package com.jiyingda.Leetcode;

public class Leet9 {

    public static void main(String[] args){
        System.out.println(isPalindrome(122));;

    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else if(x == 0){
            return true;
        }else{
            String s = "" + x;
            char[] sss = s.toCharArray();
            int length = s.length();
            boolean flag = true;
            for(int i = 0; i < length / 2; i++){
                if(sss[i] != sss[length-i-1]){
                    flag = false;
                    break;
                }

            }
            return flag;

        }


    }
}
