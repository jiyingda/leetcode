package com.jiyingda.leetcode200;

/**
 * @author jiyingda.
 * @date 2020/7/23.
 */
public class Leet1025 {

    public static void main(String[] args){

    }
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        if(N <= 1){
           return false;
        }
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            dp[i] = false;

            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i-x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

}
