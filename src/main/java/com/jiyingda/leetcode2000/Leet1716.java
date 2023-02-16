/**
 * @(#)Leet1716.java, 2月 10, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 *
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 *
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * https://leetcode.cn/problems/calculate-money-in-leetcode-bank/
 * @author jiyingdabj
 */
public class Leet1716 {

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
        System.out.println(totalMoney(10));
    }
    static int[] nums = new int[1000];



    public static int totalMoney(int n) {
        if (nums[n-1] > 0) {
            return nums[n-1];
        }
        int i = 0;
        int s = 0;
        int all = 0;
        int c = 0;
        while (i < n) {
            if (i % 7 == 0) {
                s++;
                c = s;
            } else {
                c++;
            }
            all += c;
            nums[i] = all;
            i++;
        }

        return all;
    }
}
