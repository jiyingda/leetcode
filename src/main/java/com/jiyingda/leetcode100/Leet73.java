package com.jiyingda.leetcode100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingda.
 * @date 2020/7/13.
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leet73 {

    public static void main(String[] args){
        int[][] matrix  = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.print(matrix);

    }

    public static void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    setX.add(i);
                    setY.add(j);
                }
            }
        }
        for (int i : setX) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : setY) {
            for (int i = 0; i < x; i++) {
                matrix[i][j] = 0;
            }
        }
    }


    public static void setZeroes2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> nL = new HashSet<>();
        Set<Integer> mL = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    nL.add(i);
                    mL.add(j);
                }
            }
        }

        for(int i : nL){
            for(int j = 0; j < m ;j++){
                matrix[i][j] = 0;
            }
        }

        for(int j : mL){
            for(int i = 0; i < n ;i++){
                matrix[i][j] = 0;
            }
        }

    }
}
