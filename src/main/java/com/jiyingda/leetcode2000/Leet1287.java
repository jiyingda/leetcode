/**
 * @(#)Leet1287.java, 6月 29, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 *  
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet1287 {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(findSpecialInteger(arr));;
    }


    public static int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int i = 0;
        int j = i + len / 4;
        while (j < len) {
            if (arr[i] == arr[j]) {
                return arr[i];
            }
            i++;
            j++;
        }
        return -1;
    }
}
