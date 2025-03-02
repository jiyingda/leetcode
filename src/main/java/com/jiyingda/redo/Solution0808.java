/**
 * @(#)Solution0808.java, 8月 08, 2024.
 * <p>
 * Copyright 2024 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Solution0808 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}};

        List<Integer> list = spiralOrder(matrix);
        for (int k : list) {
            System.out.print(k + " -> ");
        }

    }
    // 0,0   top
    // left      right
    //      bottom

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int i = 0; int j = 0;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int k = 0;
        int all = row * col;
        while (k < all) {
            while (k < all && j <= right) {
                res.add(matrix[i][j]);
                k++;
                j++;
            }
            j = right;
            top = top + 1;
            i = top;
            while (k < all && i <= bottom) {
                res.add(matrix[i][j]);
                k++;
                i++;
            }
            right = right - 1;
            j = right;
            i = bottom;
            while (k < all && j >= left) {
                res.add(matrix[i][j]);
                k++;
                j--;
            }
            bottom = bottom - 1;
            i = bottom;
            j = left;
            while (k < all && i >= top) {
                res.add(matrix[i][j]);
                k++;
                i--;
            }
            left = left + 1;
            j = left;
            i = top;
        }
        return res;
    }
}