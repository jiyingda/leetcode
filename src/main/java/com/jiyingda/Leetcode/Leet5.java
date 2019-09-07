package com.jiyingda.Leetcode;

public class Leet5 {

    public static void main(String... args){
        String rrrr = longestPalindrome("ccd");
        System.out.println(rrrr);
    }

    public static String longestPalindrome(String s) {
        if("".equals(s)){
            return s;
        }
        char[] sss = s.toCharArray();
        if(sss.length == 1){
            return s;
        }
        if(sss.length == 2){
            if(sss[0]==sss[1]){
                return s;
            }else {
                return "" + sss[0];
            }
        }
        int start = 0;
        int end = 0;
        int length = 0;

        for(int i = 0; i < sss.length; i++){
            for(int k = 1; k <= i; k++){
                if(i-k >= 0 && i + k < sss.length && sss[i-k] == sss[i+k]){

                }else{
                    if((i + k - 1)- (i - k + 1) > length){
                        start = i - k + 1;
                        end = i + k - 1;
                        length = end - start;
                    }
                    break;
                }
                if((i == k || i + k == (sss.length -1)) && sss[i-k] == sss[i+k]){
                    if((i + k)- (i - k ) > length){
                        start = i - k ;
                        end = i + k ;
                        length = end - start;
                    }
                    break;
                }
            }

            for(int k = 0; k <= i; k++){
                if(i-k >= 0 && i + k + 1 < sss.length && sss[i-k] == sss[i + k + 1]){

                }else{
                    if((i + k + 1 - 1)- (i - k + 1) > length){
                        start = i - k + 1;
                        end = i + k + 1 - 1;
                        length = end - start;
                    }
                    break;
                }

                if((i == k || i + k + 1 == (sss.length -1)) && sss[i-k] == sss[i + k + 1]){
                    if((i + k + 1)- (i - k ) > length){
                        start = i - k;
                        end = i + k + 1;
                        length = end - start;
                    }
                    break;
                }
            }
        }
        return s.substring(start,end + 1);
    }
}
