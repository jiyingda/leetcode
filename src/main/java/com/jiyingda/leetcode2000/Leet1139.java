/**
 * @(#)Leet1139.java, 2月 17, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 示例 2：
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 *
 * https://leetcode.cn/problems/largest-1-bordered-square/
 *
 * @author jiyingdabj
 */
public class Leet1139 {

    public static void main(String[] args) {

    }


    public static int largest1BorderedSquare(int[][] grid) {
        int w = grid[0].length;
        int h = grid.length;
        int[][] dp = new int[grid[0].length][grid.length];
        int max = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                dp[i][j] = Math.max();


            }

        }

        return 1;
    }
}
