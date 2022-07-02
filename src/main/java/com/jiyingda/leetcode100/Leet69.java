package com.jiyingda.leetcode100;

/**
 * @author jiyingda
 * @date 2020/6/2
 */
public class Leet69 {

    public static void main(String[] args){
        System.out.println(mySqrt(2147395599));;
    }


    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }
}
