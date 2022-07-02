package com.jiyingda.leetcode100;

/**
 * @author jiyingda.
 * @date 2019/9/7.
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet55 {

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 0, 1};
        System.out.println(canJump(nums));;


    }


    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (dp[0] < 1 && nums.length > 1) {
            return false;
        }
        for (int i = 1; i < nums.length-1; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] - 1);
            if (dp[i] < 1) {
                return false;
            }
            if (dp[i] >= nums.length - 1 - i) {
                return true;
            }
        }
        return true;
    }


    public static boolean canJump2(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int len = nums.length;
        int i = 1;
        int m = nums[0];
        while ( i < len){
            if(m == 0){
                return false;
            }
            m = Math.max(m, nums[i] + i);
            if(m <= i){
                return false;
            }
            if(m >= len - 1){
                return true;
            }
            i++;

        }


        return false;
    }
}
