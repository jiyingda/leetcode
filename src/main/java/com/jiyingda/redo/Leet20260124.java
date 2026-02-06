/**
 * @(#)Leet20260124.java, 1月 24, 2026.
 * <p>
 * Copyright 2026 . All rights reserved.
 * 
 */
package com.jiyingda.redo;

import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Leet20260124 {

    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(2, 3),
                Arrays.asList(1, -1, -3)
        );
        int min = minimumTotal(triangle);
        System.out.println(min);

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[] dp = new int[(1 + height) * height / 2];
        int i = 0;
        dp[i] = triangle.get(0).get(0);
        i++;
        for (int k = 1; k < height; k++) {
            int w = k + 1;
            int right = (1 + (w - 1)) * (w-1) / 2 - 1;
            int left = right - (w - 1) + 1;
            for (int j = 0; j < w; j++) {
                if (j == 0) {
                    dp[i] = dp[left] + triangle.get(k).get(j);
                } else if (j == w - 1) {
                    dp[i] = dp[right] + triangle.get(k).get(j);
                } else {
                    dp[i] = Math.min(dp[left + j], dp[left + j - 1])  + triangle.get(k).get(j);
                }
                i++;
            }
        }
        int start = i - height;
        int min = Integer.MAX_VALUE;
        while (start < i) {
            min = Math.min(dp[start], min);
            start++;
        }
        return min;
    }
}