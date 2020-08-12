package com.jiyingda.leetcode150;

/**
 * @author jiyingda
 * @date 2020/8/12 23:26
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet221 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length < 1){
            return 0;
        }
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] =='1'? 1:0;
            max = Math.max(dp[i][0], max);
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i] =='1'? 1:0;
            max = Math.max(dp[0][i], max);
        }
        if(n < 2 || m < 2){
            return max;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                char c = matrix[i][j];
                if(c == '1'){
                    char l = matrix[i-1][j-1];
                    if(l == '0'){
                        dp[i][j] = 1;
                    } else {
                        int ll = is111(matrix, i, j, dp[i-1][j-1]);
                        dp[i][j] = ll + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max * max;
    }

    public static int is111(char[][] mat, int i, int j,int len){
        int l = 0;
        int k = i-1;
        int t = j-1;
        while (k+len >= i){
            if(mat[k][j] == '0' || mat[i][t] == '0'){
                return l;
            }
            k--;
            t--;
            l++;
        }
        return l;
    }
}
