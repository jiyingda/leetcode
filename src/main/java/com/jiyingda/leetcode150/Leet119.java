package com.jiyingda.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/15.
 */
public class Leet119 {

    public static void main(String[] args){
        List<Integer> list = getRow(5);
        for(Integer i : list){
            System.out.print(i + ", ");
        }

    }


    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return Arrays.asList(1);
        }
        if(rowIndex == 1){
            return Arrays.asList(1,1);
        }
        rowIndex++;
        Integer[] a = new Integer[rowIndex];
        Integer[] b = new Integer[rowIndex];
        a[0] = 1;
        a[1] = 1;
        int b_l = 3;
        for(int i = 2; i < rowIndex; i++){
            b[0] = 1;
            b[b_l-1] = 1;
            for(int j = 1; j < b_l-1; j++){
                b[j] = a[j] + a[j-1];
            }
            Integer[] c = a;
            a = b;
            b = c;
            b_l ++;
        }

        return Arrays.asList(a);
    }
}
