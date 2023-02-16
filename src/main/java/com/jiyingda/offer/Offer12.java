/**
 * @(#)Offer12.java, 9月 27, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.Arrays;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer12 {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','B','C','E'}
        };
        System.out.println(exist(board, "ECBA"));
    }



    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    /*char[][] temp = new char[board.length][board[0].length];
                    for (int s = 0; s < board.length; s++) {
                        temp[s] = Arrays.copyOf(board[s], board[0].length);
                    }*/


                    boolean f = exist(board, i, j, 0, chars);
                    if (f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int a, int b, int k, char[] chars) {
        if (k == chars.length) {
            return true;
        }
        if (a < 0 || b < 0 || a >= board.length || b >= board[0].length || k > chars.length) {
            return false;
        }
        if (board[a][b] == '#') {
            return false;
        }
        if (board[a][b] == chars[k]) {
            board[a][b] = '#';
            boolean f1 = exist(board, a -1, b, k + 1, chars);
            if (f1) {
                return true;
            }
            boolean f2 = exist(board, a, b-1, k + 1, chars);
            if (f2) {
                return true;
            }
            boolean f = exist(board, a + 1, b, k + 1, chars);
            if (f) {
                return true;
            }
            boolean f3 = exist(board, a , b + 1, k + 1, chars);
            if (f3) {
                return true;
            }
            board[a][b] = chars[k];
        }
        return false;
    }
}