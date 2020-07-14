package com.jiyingda.leetcode150;

/**
 * @author jiyingda.
 * @date 2020/7/14.
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leet198 {

    public static void main(String[] args){


        int[] ss = new int[]{2,7,9,3,1};
        System.out.print(rob(ss));;


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
        int[] ss = new int[len];
        ss[0] = nums[0];
        ss[1] = nums[1];
        ss[2] = nums[2] + ss[0];
        int max = Math.max(ss[2], ss[1]);

        for(int i = 3; i < len; i++){
            ss[i] = Math.max(nums[i] + ss[i-2], nums[i] + ss[i-3]);
            max = Math.max(max, ss[i]);
        }
        return max;
    }
}
