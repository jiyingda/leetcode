package com.jiyingda.leetcode1000;

import java.util.Arrays;

/**
 *
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 注意：
 *
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2021/2/17
 */
public class Leet566 {

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        int[][] num = matrixReshape(nums, 1,4);
        System.out.println(Arrays.toString(num));

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int b = nums[0].length;
        int l = 0;
        int[][] re = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int t = l % b;
                int p = l / b;
                re[i][j] = nums[p][t];
                l++;
            }
        }
        return re;
    }
}
