package com.jiyingda.leetcode200;

/**
 * @author jiyingda
 * @date 2020/12/21 21:22
 */
public class Leet154 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,2,2,1};
        System.out.print(findMin(nums));
    }


    public static int findMin(int[] nums) {
        return Math.min(findMin(nums, 0, nums.length-1), nums[0]);
    }

    public static int findMin(int[] nums, int a, int d) {
        if(d - a <= 1){
            return Math.min(nums[a], nums[d]);
        }
        int b = (d-a)/2 + a;
        int c = b + 1;
        while (nums[b] == nums[c] && c < d){
            c++;
        }
        while (nums[b] == nums[c] && b > a) {
            b--;
        }
        if(nums[b] == nums[c]){
            return Math.min(Math.min(nums[a], nums[d]), nums[b]);
        }
        if(nums[b] > nums[c]){
            return nums[c];
        }else {
            if(nums[a] > nums[c]){
                return findMin(nums, a, b);
            } else if(nums[a] == nums[c]){
                return Math.min(findMin(nums, a, b), findMin(nums, c, d));

            } else {
                return findMin(nums, c, d);
            }
        }
    }
}
