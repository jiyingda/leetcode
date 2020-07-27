package com.jiyingda.leetcode100;

import java.util.Collections;

/**
 * @author jiyingda.
 * @date 2020/7/27.
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet74 {



    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,4},{5,7,9}};
        System.out.print(searchMatrix(matrix, 6));;
    }

    public static boolean ddd(int[][] matrix, int target, int a, int b, int s){
        if(b==a){
            return matrix[s][a] == target;
        }
        int mid = (b-a)/2 + a + 1;
        if(matrix[s][mid] > target){
            return ddd(matrix, target, a, mid-1, s);
        } else if(matrix[s][mid] == target){
            return true;
        } else {
            return ddd(matrix, target, mid, b, s);
        }
    }


    public static boolean sss(int[][] matrix, int target, int a, int b){
        if(b-a == 0){
            return ddd(matrix, target, 0, matrix[0].length-1, a);
        }
        int mid = (b-a)/2 + a + 1;

        if(matrix[mid][0] > target){
            return sss(matrix, target, a, mid-1);
        } else if(matrix[mid][0] == target) {
            return true;
        } else {
            return sss(matrix, target, mid, b);
        }
    }



    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] > target){
            return false;
        }
        if(matrix[m-1][n-1] < target){
            return false;
        }

        return sss(matrix, target, 0 , m-1);
    }
}
