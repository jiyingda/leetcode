package com.jiyingda.leetcode100;

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/9 21:51
 */
public class Leet81 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        System.out.print(search(nums, 6));;

    }

    public static boolean search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return true;
            } else if(nums[i] < target){

            } else {

                int a = nums[nums.length-1];
                if(a == target){
                    return true;
                }

                int j = nums.length-2;
                while (j >= 0 && nums[j] < a){
                    if(nums[j] == target){
                        return true;
                    }
                    j--;
                }
            }
        }

        return false;
    }
}
