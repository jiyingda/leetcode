/**
 * @(#)Leet79.java, 1月 27, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode100;

/**
 * @author jiyingda
 */
public class Leet79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "EEDA"));

    }



    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        int X = board.length;
        int Y = board[0].length;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (board[i][j] == w[0]) {
                    boolean f = find(board, w, i, j, 0, X, Y);
                    if (f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean find(char[][] board, char[] word, int i, int j, int k, int X, int Y) {
        if (k == word.length -1) {
            return true;
        }
        char t = board[i][j];
        board[i][j] = '-';
        k++;
        if (i + 1 < X && board[i + 1][j] == word[k]) {
            boolean f = find(board, word, i + 1, j, k, X, Y);
            if (f) {
                board[i][j] = t;
                return true;
            }
        }
        if (i - 1 >= 0 && board[i - 1][j] == word[k]) {
            boolean f = find(board, word, i - 1, j, k, X, Y);
            if (f) {
                board[i][j] = t;
                return true;
            }
        }
        if (j - 1 >= 0 && board[i][j - 1] == word[k]) {
            boolean f = find(board, word, i, j - 1, k, X, Y);
            if (f) {
                board[i][j] = t;
                return true;
            }
        }
        if (j + 1 < Y && board[i][j + 1] == word[k]) {
            boolean f = find(board, word, i, j + 1, k, X, Y);
            if (f) {
                board[i][j] = t;
                return true;
            }
        }
        board[i][j] = t;
        return k >= word.length;
    }
}