/**
 * @(#)M0112.java, 6月 22, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.ms;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 *
 *
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 *
 * 输入：matrix = [[1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fpTFWP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class M0112 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{7,7,5},{2,4,6},{8,2,0}};
        int len = longestIncreasingPath(matrix);
        System.out.println(len);

    }

    public static int longestIncreasingPath(int[][] matrix) {

        max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int len = longestIncreasingPath(matrix, i, j, n, m, -1, dp);
                dp[i][j] = len;
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static int max = 0;

    public static int longestIncreasingPath(int[][] matrix, int i, int j, int n, int m, int val, int[][] dp) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }
        if (matrix[i][j] <= val) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int a = longestIncreasingPath(matrix, i, j + 1, n, m, matrix[i][j], dp);
        if (a > 0) {
            dp[i][j + 1] = a;
        }
        int b = longestIncreasingPath(matrix, i, j - 1, n, m, matrix[i][j], dp);
        if (b > 0) {
            dp[i][j - 1] = b;
        }
        int c = longestIncreasingPath(matrix, i - 1, j, n, m, matrix[i][j], dp);
        if (c > 0) {
            dp[i - 1][j] = c;
        }

        int d = longestIncreasingPath(matrix, i + 1, j, n, m, matrix[i][j], dp);
        if (d > 0) {
            dp[i + 1][j] = d;
        }

        return Math.max(Math.max(a, b), Math.max(c, d)) + 1;
    }
}
