package com.jiyingda.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/4/9.
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet54 {

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},{4,5,6}
        };
        List<Integer> reList = spiralOrder(matrix);
        for(Integer i : reList){
            System.out.print(i + ",");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> reList = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return reList;
        }
        if(matrix.length == 1){
            for(int i = 0; i < matrix[0].length; i++){
                reList.add(matrix[0][i]);
            }
            return reList;
        }
        if(matrix[0].length == 1){
            for(int i = 0; i < matrix.length; i++){
                reList.add(matrix[i][0]);
            }
            return reList;
        }
        int nl = 0;
        int nr = matrix[0].length - 1;
        int ml = 0;
        int mr = matrix.length -1;
        int i = 0;
        int j = 1;
        int fx = 0;

        reList.add(matrix[0][0]);
        while ((nl <= j && j <= nr) && (ml <=i && i <= mr)){
            if(fx == 0){
                while (j < nr){
                    reList.add(matrix[i][j]);
                    j++;
                }
                reList.add(matrix[i][j]);
                fx = 1;
                ml++;
                i++;
            }else if(fx == 1){
                while(i < mr){
                    reList.add(matrix[i][j]);
                    i++;
                }
                reList.add(matrix[i][j]);
                fx = 2;
                nr--;
                j--;
            }else if(fx == 2){
                while (j > nl){
                    reList.add(matrix[i][j]);
                    j--;
                }
                reList.add(matrix[i][j]);
                fx = 3;
                mr--;
                i--;
            }else {
                //fx == 3
                while (i > ml){
                    reList.add(matrix[i][j]);
                    i--;
                }
                reList.add(matrix[i][j]);
                fx = 0;
                nl++;
                j++;
            }
        }

        return reList;

    }
}
