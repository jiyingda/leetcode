package com.jiyingda.leetcode;

public class Leet6 {
    public static void main(String... args){
        System.out.println(convert("PAHNAPLSIIGYIR", 4));
        System.out.println("PAHNAPLSIIGYIR");

    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        if(length <= numRows){
            return s;
        }
        if(numRows == 1){
            return s;
        }
        int k = length / (numRows - 1) + 1;
        char[] sss = s.toCharArray();
        char[] re = new char[length];
        int w = 0;

        for(int i = 0; i < numRows; i++){
            re[w] = sss[i];
            w++;
            for(int j = 1; j < k; j++){
                int real = 0;
                if(j % 2 == 0){
                    if(i > 0){
                        real = j * (numRows - 1) + (i);
                    }
                } else {
                    if(i < numRows - 1){
                        real = j * (numRows - 1) + (numRows - 1 - i);
                    }
                }
                if(real > 0 && real < length && w < length){
                    re[w] = sss[real];
                    w++;
                }
            }
        }

        return String.valueOf(re);
    }
}
