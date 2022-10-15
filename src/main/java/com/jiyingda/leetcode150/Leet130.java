/**
 * @(#)Leet130.java, 1月 30, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode150;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet130 {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}

        };
        solve(board);
        System.out.println(1);
    }


    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                solve(board, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                solve(board, n - 1, j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                solve(board, i, 0);
            }
            if (board[i][m -1] == 'O') {
                solve(board, i, m - 1);
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void solve(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'A' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = 'A';
        solve(board, i - 1, j);
        solve(board, i + 1, j);
        solve(board, i, j - 1);
        solve(board, i, j + 1);
    }
}
