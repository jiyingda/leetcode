package com.jiyingda.leetcode;

/**
 * @author jiyingda.
 * @date 2020/3/3.
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedMergeLcci {

    public static void main(String[] args){
        int[] A = {2,5,6,0,0,0};
        int[] B = {1,2,3};
        merge(A, 3, B, 3);
    }



    public static void merge(int[] A, int m, int[] B, int n) {

        int i = m-1;
        int j = n-1;
        int t = m + n - 1;
        while (i >= 0 && j >= 0){
            if(A[i] >= B[j]){
                A[t] = A[i];
                i--;
            } else {
                A[t] = B[j];
                j--;
            }
            t--;
        }
        while (j >= 0){
            A[t] = B[j];
            j--;
            t--;
        }

        System.out.println(A);
    }
}
