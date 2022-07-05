package com.jiyingda.leetcode500;

/**
 * @author jiyingda.
 * @date 2020/8/10.
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet213 {



    public static void main(String[] args){
        int[] nums = new int[]{2,3,2};
        System.out.print(rob(nums));;

    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len < 3){
            int max = 0;
            for(int n : nums){
                max = Math.max(max, n);
            }
            return max;
        }
        int a0 = nums[0];
        nums[0] = 0;
        int a = robs(nums);
        nums[0] = a0;
        nums[len-1] = 0;
        int b = robs(nums);
        return Math.max(a,b);
    }

    public static int robs(int[] nums) {
        int len = nums.length;
        int[] ss = new int[len];
        ss[0] = nums[0];
        ss[1] = nums[1];
        ss[2] = nums[2] + ss[0];
        int max = Math.max(ss[2], ss[1]);

        for(int i = 3; i < len; i++){
            ss[i] = Math.max(nums[i] + ss[i-2], nums[i] + ss[i-3]);
            //max = Math.max(max, ss[i]);
        }
        return Math.max(ss[len-2], ss[len-1]);
    }
}
