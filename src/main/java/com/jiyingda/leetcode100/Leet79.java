/**
 * @(#)Leet79.java, 1月 27, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode100;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *  
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED"));

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
        if (k >= word.length - 1) {
            return true;
        }
        char t = board[i][j];
        board[i][j] = '-';
        k++;
        if (i + 1 < X && board[i + 1][j] == word[k]) {
            boolean f = find(board, word, i + 1, j, k, X, Y);
            if (f) {
                return true;
            }
        }
        if (i - 1 >= 0 && board[i - 1][j] == word[k]) {
            boolean f = find(board, word, i - 1, j, k, X, Y);
            if (f) {
                return true;
            }
        }
        if (j - 1 >= 0 && board[i][j - 1] == word[k]) {
            boolean f = find(board, word, i, j - 1, k, X, Y);
            if (f) {
                return true;
            }
        }
        if (j + 1 < Y && board[i][j + 1] == word[k]) {
            boolean f = find(board, word, i, j + 1, k, X, Y);
            if (f) {
                return true;
            }
        }
        board[i][j] = t;
        return k >= word.length - 1;
    }
}
