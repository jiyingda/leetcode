package com.jiyingda.leetcode200;

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/21 19:16
 */
public class Leet153 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.print(findMin(nums));
    }


    public static int findMin(int[] nums) {
        return Math.min(findMin(nums, 0, nums.length-1), nums[0]);
    }

    public static int findMin(int[] nums, int a, int d) {
        if(d - a <= 1){
            return Math.min(nums[a], nums[d]);
        }
        int b = (d-a)/2 + a;
        int c = b + 1;
        if(nums[b] > nums[c]){
            return nums[c];
        }else {
            if(nums[a] > nums[c]){
                return findMin(nums, a, b);
            } else {
                return findMin(nums, c, d);
            }
        }
    }
}
