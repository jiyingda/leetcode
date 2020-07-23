package com.jiyingda.leetcode100;

/**
 * @author jiyingda.
 * @date 2020/7/17.
 */
public class Leet96 {


    public static void main(String[] args){

    }

    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
