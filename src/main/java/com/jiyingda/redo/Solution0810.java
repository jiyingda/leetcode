/**
 * @(#)Solution0810.java, 8月 10, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

/**
 * @author jiyingda
 */
public class Solution0810 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{1,1},{1,0}};
        gameOfLife(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.print("\n");
        }

    }

    public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] newBoard = new int[n + 2][m + 2];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, newBoard[i + 1], 1, m);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                board[i - 1][j - 1] = check(newBoard, i, j);
            }
        }

    }

    /**
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     */
    private static int check(int[][] newBoard, int i, int j) {
        int count = newBoard[i - 1][j - 1]
                + newBoard[i - 1][j]
                + newBoard[i - 1][j + 1]
                + newBoard[i][j - 1]
                + newBoard[i][j + 1]
                + newBoard[i + 1][j - 1]
                + newBoard[i + 1][j]
                + newBoard[i + 1][j + 1];

        if (newBoard[i][j] == 0) {
            return count == 3 ? 1 : 0;
        } else {
            if (count < 2) {
                return 0;
            }
            if (count <= 3) {
                return 1;
            }
            return 0;
        }
    }
}