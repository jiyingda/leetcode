/**
 * @(#)Leet1137.java, 8月 08, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *  
 *
 * 提示：
 *
 * 0 <= n <= 37
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Leet1137 {

    public static int[] map = new int[38];
    static {
        map[0] = 0;
        map[1] = 1;
        map[2] = 1;
    }


    public static int tribonacci(int n) {
        if (n <= 2) {
            return map[n];
        }
        if (map[n] > 0) {
            return map[n];
        }
        for (int i = 3; i <= n; i++) {
            if (map[i] > 0) {
                continue;
            }
            map[i] = map[i - 1] + map[i - 2] + map[i - 3];
        }
        return map[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}