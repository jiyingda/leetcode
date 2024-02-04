/**
 * @(#)Offer53.java, 1月 29, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer53 {

    public static void main(String[] args) {
        int[] nums = new int[]{11};
        System.out.print(search(nums, 11));
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (nums[left] > target || nums[right] < target) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target) {
            int n = 1;
            int i = mid + 1;
            int j = mid - 1;
            while (i <= right && nums[i] == target) {
                i++;
                n++;
            }
            while (j >= left && nums[j] == target) {
                j--;
                n++;
            }
            return n;
        }
        if (nums[mid] < target) {
            return search(nums, target, mid + 1, right);
        }
        return search(nums, target, left, mid - 1);
    }
}