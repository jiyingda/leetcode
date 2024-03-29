/**
 * @(#)Leet1380.java, 2月 15, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet1380 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {7,8},{1,2}
        };
        List<Integer> list = luckyNumbers(matrix);
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = matrix[i][0];
        }
        int[] max = new int[m];
        for (int i = 0; i < m; i++) {
            max[i] = matrix[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        Set<Integer> set = new HashSet<>(n + m);
        for (int i : min) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : max) {
            if (set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
