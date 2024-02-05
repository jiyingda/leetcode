/**
 * @(#)Offer47.java, 3月 08, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.Arrays;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author jiyingdabj
 */
public class Offer47 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        int k = maxValue(grid);
        System.out.println(k);
    }

    public static int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }

        return dp[n][m];
    }
}
