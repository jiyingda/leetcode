package com.jiyingda.leetcode200;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/27 21:18
 */
public class Leet209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.print(minSubArrayLen(7, nums));;

    }

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int tmp = 0;
        Integer minLen = null;
        while (right < nums.length){
            if(nums[right] >= s){
                return 1;
            }
            tmp += nums[right];
            right++;
            if(tmp >= s){
                minLen = minLen==null ? right-left : Math.min(right-left, minLen);
                while (left <= right && left < nums.length) {
                    tmp = tmp - nums[left];
                    left++;
                    if(tmp < s){
                        minLen = Math.min(right-left+1, minLen);
                        break;
                    }
                }
            }
        }
        return minLen == null ? 0 : minLen;
    }

}
