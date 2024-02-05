/**
 * @(#)Offer40.java, 10月 11, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer40 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        int[] rrr = getLeastNumbers(arr, 1);
        for (int i : rrr) {
            System.out.print(i + ", ");
        }
    }


    public static int[] getLeastNumbers(int[] arr, int k) {
        sort(arr, k, 0, arr.length-1);
        return Arrays.copyOf(arr, k);
    }

    public static void sort(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int base = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= base) {
                r--;
            }
            while (l < r && arr[l] <= base) {
                l++;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = base;
        if (l == k) {
            return;
        }
        if (l < k) {
            sort(arr, k, l + 1, right);
        } else {
            sort(arr, k, left, l - 1);
        }
    }
}