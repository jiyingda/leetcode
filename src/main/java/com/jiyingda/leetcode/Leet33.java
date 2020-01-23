package com.jiyingda.leetcode;

/**
 * @author jiyingda.
 * @date 2020/1/14.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet33 {

    public static void main(String[] args){

        int[] nums = {0,1,2};
        for(int a : nums){
            System.out.println(search(nums, 3));;

        }
    }


    public static int search(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            } else if(nums[i] < target){

            } else {

                int a = nums[nums.length-1];
                if(a == target){
                    return nums.length-1;
                }

                int j = nums.length-2;
                while (j >= 0 && nums[j] < a){
                    if(nums[j] == target){
                        return j;
                    }
                    j--;
                }
            }
        }

        return -1;
    }
}
