package com.jiyingda.leetcode200;

import java.util.Arrays;

/**
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/21 22:55
 */
public class Leet162 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.print(findPeakElement(nums));;


    }


    public static int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = Integer.MIN_VALUE;
        newNums[newNums.length-1] = Integer.MIN_VALUE;
        return findPeakElement(newNums, 0, newNums.length-1) - 1;
    }

    public static int findPeakElement(int[] nums, int left, int right) {
        if(right - left < 2){
            return -1;
        }
        if(right - left == 2){
            if((nums[left] < nums[left + 1]) && (nums[left + 1] > nums[right])){
                return left + 1;
            } else {
                return -1;
            }
        }
        int mid = left + (right - left) / 2;
        if((nums[mid-1] < nums[mid]) && (nums[mid] > nums[mid+1])){
            return mid;
        }
        int a = findPeakElement(nums, left, mid);
        if(a >= 0){
            return a;
        }
        return findPeakElement(nums, mid, right);
    }
}
