package com.jiyingda.leetcode;

/**
 * @author jiyingda.
 * @date 2020/1/30.
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet34 {

    public static void main(String[] args){

        int[] nums = {4,5};
        searchRange(nums, 5);;
    }

    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] errorList = {-1, -1};
        if(nums == null || nums.length < 1){
            return errorList;
        }
        int len = nums.length;
        if(nums[0] > target || nums[len - 1] < target){
            return errorList;
        }
        if(len == 1){
            if(nums[0] == target){
                errorList[0] = 0;
                errorList[1] = 0;
                return errorList;
            }
            return errorList;
        }
        ff(nums, target, 0, len-1, errorList);
        return errorList;

    }

    public static void ff(int[] nums, int target, int left, int right, int[] reList){
        if(left > right){
            return;
        }
        if(left == right){
            if(nums[left] == target){
                reList[0] = left;
                reList[1] = left;
                return;
            }
            return;
        }
        int miden = left + (right - left) / 2;
        if(nums[miden] == target){
            int a = miden;
            while (a >= left && nums[a] == target){
                a--;
            }
            int b = miden;
            while (b <= right && nums[b] == target){
                b++;
            }
            reList[0] = a + 1;
            reList[1] = b - 1;
            return;
        }else if(nums[miden] < target){
            ff(nums, target, miden +1, right, reList);
        }else{
            ff(nums, target, left, miden, reList);
        }
    }

    /**
     * 线性查找
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRangeOld(int[] nums, int target) {
        int[] errorList = {-1, -1};
        if(nums == null || nums.length < 1){
            return errorList;
        }
        int len = nums.length;
        if(nums[0] > target || nums[len - 1] < target){
            return errorList;
        }
        int a = -1;
        int b = -1;
        for(int i = 0; i < len; i++){
            if(nums[i] == target){
                a = i;
                b = a;
                i++;
                while (i < len && nums[i] == target){
                    b = i;
                    i++;
                }
                break;
            }
        }
        errorList[0] = a;
        errorList[1] = b;
        return errorList;

    }
}
