package com.jiyingda.leetcode200;

/**
 *
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *  
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2021/2/16
 */
public class Leet485 {

    public static void main(String[] args){
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int tempLen = 0;
        for (int n : nums) {
            if (n == 1) {
                tempLen++;
            } else {
                maxLen = Math.max(maxLen, tempLen);
                tempLen = 0;
            }
        }
        return Math.max(maxLen, tempLen);
    }
}
