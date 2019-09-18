package com.jiyingda.leetcode;

/**
 * @author jiyingda
 * @date 2019/9/7
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet45 {

    public static void main(String[] args){
        int[] nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        jump(nums);
    }


    public static int jump(int[] nums) {
        int[] pd = new int[nums.length];
        int m = nums[0];
        pd[0] = 0;
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            for(;j <= m && j < nums.length; j++){
                pd[j] = pd[i-1] + 1;
            }
            if(m < nums[i] + i){
                m = nums[i] + i;
            }
        }
        return pd[nums.length - 1];
    }
}
