package com.jiyingda.leetcode50;

/**
 * @author jiyingda.
 * @date 2020/4/11.
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet59 {

    public static void main(String[] args){
        generateMatrix(3);
    }


    public static int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];

        int nl = 0;
        int nr = n - 1;
        int ml = 0;
        int mr = n -1;
        int i = 0;
        int j = 1;
        int fx = 0;
        int kk = 1;

        matrix[0][0] = kk;
        kk++;
        while ((nl <= j && j <= nr) && (ml <=i && i <= mr)){


            if(fx == 0){
                while (j < nr){
                    matrix[i][j] = kk;
                    kk++;
                    j++;
                }
                if(j == nr) {
                    matrix[i][j] = kk;
                    kk++;
                    fx = 1;
                    ml++;
                    i++;
                } else {
                    break;
                }
            }else if(fx == 1){
                while(i < mr){
                    matrix[i][j] = kk;
                    kk++;
                    i++;
                }
                if(i == mr){
                    matrix[i][j] = kk;
                    kk++;
                    fx = 2;
                    nr--;
                    j--;
                } else {
                    break;
                }
            }else if(fx == 2){
                while (j > nl){
                    matrix[i][j] = kk;
                    kk++;
                    j--;
                }
                if(j == nl) {
                    matrix[i][j] = kk;
                    kk++;
                    fx = 3;
                    mr--;
                    i--;
                } else {
                    break;
                }
            }else {
                //fx == 3
                while (i > ml){
                    matrix[i][j] = kk;
                    kk++;
                    i--;
                }
                if(i == ml) {
                    matrix[i][j] = kk;
                    kk++;
                    fx = 0;
                    nl++;
                    j++;
                } else {
                    break;
                }
            }
        }


        return matrix;
    }
}
