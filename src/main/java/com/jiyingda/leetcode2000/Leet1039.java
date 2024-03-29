/**
 * @(#)Leet1039.java, 4月 02, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 *
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 *
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 *
 *
 *
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 *
 *
 *
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 *
 *
 * 提示：
 *
 * n == values.length
 * 3 <= n <= 50
 * 1 <= values[i] <= 100
 *
 * https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/description/
 *
 * @author jiyingda
 */
public class Leet1039 {
    public static void main(String[] args) {

    }
    Map<Integer, Integer> memo;
    public int minScoreTriangulation(int[] values) {
        memo = new HashMap<>();
        return dfs(values, 0, values.length - 1);
    }

    public int dfs(int[] values, int i, int j) {
        if (j - i < 2) {
            return 0;
        }
        if (j - i == 2 ) {
            return values[i] * values[i + 1] * values[j];
        }
        int key = i * values.length + j;
        if (!memo.containsKey(key)) {
            int minScore = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                minScore = Math.min(minScore, values[i] * values[k] * values[j] * dfs(values, i, k) + dfs(values, k, j));
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }
}