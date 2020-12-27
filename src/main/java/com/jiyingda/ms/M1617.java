package com.jiyingda.ms;

/**
 *
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/27 20:24
 */
public class M1617 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums));

    }


    public static int maxSubArray(int[] nums) {

        //int[] dp = new int[nums.length];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
