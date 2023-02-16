/**
 * @(#)Leet540.java, 2月 14, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet540 {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(10, 1001);
        map.put(11, 1002);
        System.out.println(JSONObject.toJSON(map).toString());

        Leet540 leet540 = new Leet540();
        int[] nums = new int[]{1,2,2,3,3,4,4,8,8};
        int a = leet540.singleNonDuplicate(nums);
        System.out.println(a);
    }

    public int singleNonDuplicate(int[] nums) {

        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    public int singleNonDuplicate(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }
        if (nums[mid] == nums[mid - 1]) {
            if ((mid - 1 - left) % 2 == 0) {
                return singleNonDuplicate(nums, mid + 1, right);
            } else {
                return singleNonDuplicate(nums, left, mid - 2);
            }
        } else {
            if ((mid - left) % 2 == 0) {
                return singleNonDuplicate(nums, mid + 2, right);
            } else {
                return singleNonDuplicate(nums, left, mid - 1);
            }
        }
    }
}
