package com.jiyingda.leetcode150;

/**
 * @author jiyingda
 * @date 2020/8/7 1:20
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet152 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-9,-6, -2,-3};
        System.out.print(maxProduct(nums));;

    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;

        int max = nums[0];
        int m1 = 1;
        int m2 = 1;



        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                max = Math.max(max, nums[i] * m1);
                m1 = nums[i] * m1;
                m2 = nums[i] * m2;
            } else if(nums[i] == 0){
                max = Math.max(max, nums[i]);
                m1 = 1;
                m2 = 1;
            } else {
                max = Math.max(max, nums[i] * m2);
                if(m2 < 0){
                    int m1t = m1;
                    m1 = nums[i] * m2;
                    m2 = m1t * nums[i];
                } else {
                    m2 = nums[i] * m1;
                    m1 = 1;
                }

            }
        }


        return max;
    }
}
