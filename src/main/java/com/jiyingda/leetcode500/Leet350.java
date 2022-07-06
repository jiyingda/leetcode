/**
 * @(#)Leet350.java, 7月 06, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet350 {

    public static void main(String[] args) {
        int[] s = intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int ss : s) {
            System.out.print(ss + "\t");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        int[] re = new int[nums1.length];
        int i = 0;
        for (int n2 : nums2) {
            int k = map.getOrDefault(n2, 0);
            if (k > 0) {
                re[i] = n2;
                i++;
                map.put(n2, k - 1);
            }
        }
        return Arrays.copyOf(re, i);
    }
}
