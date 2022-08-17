/**
 * @(#)Offer11.java, 9月 27, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer11 {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,1};
        System.out.println(minArray(numbers));;

    }

    public static int minArray(int[] numbers) {
        int k = doooo(numbers, 0, numbers.length-1);
        return numbers[k];
    }

    public static int doooo(int[] numbers, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (right-left)/2 + left;
        if (numbers[mid] > numbers[right]) {
            int k = doooo(numbers, mid+1, right);
            if (k >= 0) {
                return k;
            }
        } else {
            int k1 = doooo(numbers, left, mid);

            int k2 = doooo(numbers, mid+1, right);
            return numbers[k1] > numbers[k2] ? k2 : k1;
        }
        return -1;
    }
}