/**
 * @(#)Solution08032.java, 8月 03, 2024.
 * <p>
 * Copyright 2024 . All rights reserved.
 * 
 */
package com.jiyingda.redo;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * 相关标签
 *
 * Java
 *
 *
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvf0kh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Solution08032 {

    public static void main(String[] args) {
        // coins = [1, 2, 5], amount = 11
        /*for (int account = 0; account < 21; account++) {
            int a = coinChange2(new int[]{1, 2, 5}, account);
            System.out.println("account = " + account + "\tmin = " + a);
        }*/
        //[411,412,413,414,415,416,417,418,419,420,421,422]
        //8863
        //int a = coinChange2(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 822);
        //System.out.println("account = " + 8863 + "\tmin = " + a);
        int a = coinChange2(new int[]{2}, 3);
    }

    public static int coinChange2(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        return dfs(coins, amount, new int[amount + 1]);
    }

    private static int dfs(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount] != 0) {
            return count[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int a = dfs(coins, amount - coin, count);
            if (a >= 0) {
                min = Math.min(a + 1, min);
            }
        }
        count[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount];
    }


    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int c : coins) {
            if (c < dp.length) {
                dp[c] = 1;
            }
        }

        // dp[m] = min{dp[i] + dp[m-i], dp[m-1] + dp[0]}
        for (int i = coins[0]; i <= amount; i++) {
            if (dp[i] > 0) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = coins[0]; j < i; j++) {
                if (dp[j] > 0 && dp[i-j] > 0) {
                    min = Math.min(dp[j] + dp[i-j], min);
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}