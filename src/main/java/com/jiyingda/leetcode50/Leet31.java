package com.jiyingda.leetcode50;

import java.util.Arrays;

/**
 * @author jiyingda.
 * @date 2020/1/14.
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet31 {

    public static void main(String[] args){
        int[] nums = {2,3,1};
        //Arrays.sort(nums, 1, 3);
        nextPermutation(nums);
        System.out.println(nums);

    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        for(; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                int a = nums[i-1];
                int j = nums.length-1;
                while (j > (i-1)){
                    if( nums[j] > a){
                        nums[i-1] = nums[j];
                        nums[j] = a;
                        break;
                    }
                    j--;
                }

                Arrays.sort(nums, i , nums.length);
                return;
            }
        }
        Arrays.sort(nums);

    }


    public static void sort(int a, int b, int[] nums){
        Arrays.sort(nums, a , b);
    }
}
