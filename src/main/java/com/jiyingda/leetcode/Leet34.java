package com.jiyingda.leetcode;

/**
 * @author jiyingda.
 * @date 2020/1/23.
 */
public class Leet34 {

    public static void main(String[] args){

        int[] nums = {1};
        System.out.println(searchInsert(nums, 1));;
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1] < target){
            return nums.length;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
            if(nums[i] > target){
                return i;
            }
        }
        return -1;
    }
}
