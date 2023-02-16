/**
 * @(#)Offer13.java, 9月 27, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer13 {

    public static void main(String[] args) {
        System.out.println(movingCount(2,2,1));;

    }

    private static int count = 0;

    public static int movingCount(int m, int n, int k) {
        count = 0;
        int[][] aaa = new int[m][n];
        movingCount(0, 0, m, n, k, aaa);
        return count;
    }

    public static void movingCount(int a, int b, int m, int n, int k, int[][] aaa) {
        if (a >= m || b >= n) {
            return;
        }
        if (aaa[a][b] == 1) {
            return;
        }
        aaa[a][b] = 1;
        if (sum(a, b) <= k) {
            count++;
            movingCount(a + 1, b, m, n, k, aaa);
            movingCount(a , b+1, m, n, k, aaa);
        }
    }

    private static int sum(int s1, int s2) {
        return digitSum(s1) + digitSum(s2);
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}