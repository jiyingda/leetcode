/**
 * @(#)Leet977.java, 7月 06, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

import com.jiyingda.util.PrintUtils;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet977 {

    public static void main(String[] args) {
        int[] re = sortedSquares(new int[]{-7,-3,2,3,11});
        PrintUtils.printArray(re);
    }


    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int i = len - 1;
        int[] re = new int[len];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                re[i] = nums[left] * nums[left];
                left++;
            } else {
                re[i] = nums[right] * nums[right];
                right--;
            }
            i--;
        }
        return re;
    }
}
