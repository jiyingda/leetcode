package com.jiyingda.Leetcode;

/**
 * @author jiyingda
 * @date 2019/8/15
 */
public class Leet13 {


    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));;
    }


    public static int romanToInt(String s) {
        char[] ss = s.toCharArray();


        int num = 0;
        for(int i = 0; i < ss.length; i++){
            if('V' == ss[i]){
                num += 5;
            }else if('L' == ss[i]){
                num += 50;
            }else if('D' == ss[i]){
                num += 500;
            }else if('M' == ss[i]){
                num += 1000;
            }else if('I' == ss[i]){
                if(i +1 <ss.length && ss[i + 1] == 'V' ){
                    num += 4;
                    i++;
                } else if(i +1 <ss.length && ss[i + 1] == 'X') {
                    num += 9;
                    i++;
                }else {
                  num += 1;
                }

            }else if('X' == ss[i]){
                if(i +1 <ss.length && ss[i + 1] == 'L' ){
                    num += 40;
                    i++;
                } else if(i +1 <ss.length && ss[i + 1] == 'C') {
                    num += 90;
                    i++;
                }else {
                    num += 10;
                }
            }else if('C' == ss[i]){
                if(i +1 <ss.length && ss[i + 1] == 'D' ){
                    num += 400;
                    i++;
                } else if(i +1 <ss.length && ss[i + 1] == 'M') {
                    num += 900;
                    i++;
                }else {
                    num += 100;
                }
            }

        }

        return num;

    }
}
