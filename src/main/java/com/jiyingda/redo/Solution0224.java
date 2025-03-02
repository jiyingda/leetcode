/**
 * @(#)Solution0224.java, 2月 24, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * <p>
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
 * <p>
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * 解释：
 *
 *
 * 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。
 *
 * 示例 2：
 *
 * 输入：board = [["X"]]
 *
 * 输出：[["X"]]
 *
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * 作者：LeetCode
 * 链接：<a href="https://leetcode.cn/leetbook/read/top-interview-questions-hard/xwfor1/">...</a>
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Solution0224 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solution0224 solution0224 = new Solution0224();
        solution0224.solve(board);
        System.out.println(board);
    }

    public void solve(char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            int i = board.length - 1;
            if (board[i][j] == 'O') {
                dfs(board, i, j);
            }
        }
        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            int j = board[0].length - 1;
            if (board[i][j] == 'O') {
                dfs(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char cur = board[i][j];
        if ('X' == cur || 'M' == cur) {
            return;
        }
        board[i][j] = 'M';
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
    }
}