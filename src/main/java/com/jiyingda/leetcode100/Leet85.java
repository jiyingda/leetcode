package com.jiyingda.leetcode100;

/**
 * @author jiyingda
 * @date 2020/8/12 21:54
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet85 {
    public static void main(String[] args) {
        char[][] mat = new char[][]{
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'}};
        int a = maximalRectangle(mat);
        System.out.print(a);

    }
    public static int maximalRectangle(char[][] matrix) {


        return 0;
    }
}
