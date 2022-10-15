/**
 * @(#)Offer39.java, 10月 12, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer39 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 1, 1};
        int a = majorityElement(nums);
        System.out.println(a);

    }


    public static int majorityElement(int[] nums) {
        int a = 0;
        int n = 0;
        for (int num : nums) {
            if (n == 0) {
                a = num;
                n++;
            } else if (num == a) {
                n++;
            } else {
                n--;
            }
        }
        return a;
    }
}