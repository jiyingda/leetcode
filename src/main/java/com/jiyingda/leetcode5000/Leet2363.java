/**
 * @(#)Leet2363.java, 2月 28, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode5000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 *
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
 *
 * 注意：ret 应该按价值 升序 排序后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 * 输出：[[1,6],[3,9],[4,5]]
 * 解释：
 * value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 5 ，总重量为 1 + 5 = 6 。
 * value = 3 的物品再 items1 中 weight = 8 ，在 items2 中 weight = 1 ，总重量为 8 + 1 = 9 。
 * value = 4 的物品在 items1 中 weight = 5 ，总重量为 5 。
 * 所以，我们返回 [[1,6],[3,9],[4,5]] 。
 * 示例 2：
 *
 * 输入：items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
 * 输出：[[1,4],[2,4],[3,4]]
 * 解释：
 * value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 3 ，总重量为 1 + 3 = 4 。
 * value = 2 的物品在 items1 中 weight = 3 ，在 items2 中 weight = 1 ，总重量为 3 + 1 = 4 。
 * value = 3 的物品在 items1 中 weight = 2 ，在 items2 中 weight = 2 ，总重量为 2 + 2 = 4 。
 * 所以，我们返回 [[1,4],[2,4],[3,4]] 。
 * 示例 3：
 *
 * 输入：items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
 * 输出：[[1,7],[2,4],[7,1]]
 * 解释：
 * value = 1 的物品在 items1 中 weight = 3 ，在 items2 中 weight = 4 ，总重量为 3 + 4 = 7 。
 * value = 2 的物品在 items1 中 weight = 2 ，在 items2 中 weight = 2 ，总重量为 2 + 2 = 4 。
 * value = 7 的物品在 items2 中 weight = 1 ，总重量为 1 。
 * 所以，我们返回 [[1,7],[2,4],[7,1]] 。
 *
 *
 * 提示：
 *
 * 1 <= items1.length, items2.length <= 1000
 * items1[i].length == items2[i].length == 2
 * 1 <= valuei, weighti <= 1000
 * items1 中每个 valuei 都是 唯一的 。
 * items2 中每个 valuei 都是 唯一的 。
 *
 * https://leetcode.cn/problems/merge-similar-items/
 *
 * @author jiyingdabj
 */
public class Leet2363 {

    public static void main(String[] args) {
        int[][] items1 = new int[][]{{1,1},{4,5},{3,8}};
        int[][] items2 = new int[][]{{3,1},{1,5}};
        List<List<Integer>> list = mergeSimilarItems(items1, items2);
        System.out.println(list);
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, Comparator.comparing(e -> e[0]));
        Arrays.sort(items2, Comparator.comparing(e -> e[0]));
        int i = 0, j = 0;
        int len1 = items1.length;
        int len2 = items2.length;
        List<List<Integer>> list = new ArrayList<>();
        while (i < len1 && j < len2) {
            if (items1[i][0] == items2[j][0]) {
                list.add(Arrays.asList(items1[i][0], items1[i][1] + items2[j][1]));
                i++;
                j++;
            } else if (items1[i][0] < items2[j][0]) {
                list.add(Arrays.asList(items1[i][0], items1[i][1]));
                i++;
            } else {
                list.add(Arrays.asList(items2[j][0], items2[j][1]));
                j++;
            }
        }
        while (i < len1) {
            list.add(Arrays.asList(items1[i][0], items1[i][1]));
            i++;
        }
        while (j < len2) {
            list.add(Arrays.asList(items2[j][0], items2[j][1]));
            j++;
        }
        return list;
    }
}
