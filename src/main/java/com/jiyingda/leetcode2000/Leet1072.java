/**
 * @(#)Leet1072.java, 5月 15, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.leetcode2000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定 m x n 矩阵 matrix 。
 *
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 *
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 *
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 *
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 * @author jiyingdabj
 */
public class Leet1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int h = matrix.length;
        int w = matrix[0].length;
        for (int j = 0; j < h; j++) {
            if (matrix[j][0] == 1) {
                for (int i = 0; i < w; i++) {
                    if (matrix[j][i] == 1) {
                        matrix[j][i] = 0;
                    } else {
                        matrix[j][i] = 1;
                    }
                }
            }
            StringBuilder ab = new StringBuilder();
            for (int i = 0; i < w; i++) {
                ab.append(matrix[j][i]);
            }
            map.put(ab.toString(), map.getOrDefault(ab.toString(), 0) + 1);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max;
    }
}
