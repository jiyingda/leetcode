/**
 * @(#)Offer105.java, 3月 22, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.offer;

/**
 * @author jiyingdabj
 */
public class Offer105 {

    private int max;
    private int current;

    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                current = 0;
                dfs(grid, i, j, n, m);
                max = Math.max(max, current);
            }
        }

        return max;
    }

    public void dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        current++;
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
    }
}
