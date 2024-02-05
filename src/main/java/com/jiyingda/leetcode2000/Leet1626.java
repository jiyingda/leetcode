/**
 * @(#)Leet1626.java, 3月 22, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.leetcode2000;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 *
 * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 *
 * 输入：scores = [1,2,3,5], ages = [8,9,10,1]
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 *
 *
 * 提示：
 *
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 *
 * https://leetcode.cn/problems/best-team-with-no-conflicts/
 *
 * @author jiyingdabj
 */
public class Leet1626 {

    public static void main(String[] args) {
        int[] scores = new int[]{4,5,6,5};
        int[] ages = new int[]{2,1,2,1};
        //int[] scores = new int[]{2,3,10,4,7,1,5,10,3};
        //int[] ages = new int[]{1,1,1,2,2,4,4,4,5};
        int a = bestTeamScore(scores, ages);
        System.out.println(a);
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int[][] people = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            people[i][0] = scores[i];
            people[i][1] = ages[i];

        }
        Arrays.sort(people, (e1, e2)-> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            }
            return e1[1] - e2[1];
        });
        int[] dp = new int[scores.length];
        int allMax = 0;
        for (int i = 0; i < scores.length; i++) {
            int j = 0;
            int max = 0;
            while (j < i) {
                if ((people[i][1] <= people[j][1] || people[i][0] >= people[j][0])) {
                    max = Math.max(max, dp[j]);
                }
                j++;
            }
            dp[i] = max + people[i][0];
            allMax = Math.max(allMax, dp[i]);
        }
        return allMax;
    }
}
