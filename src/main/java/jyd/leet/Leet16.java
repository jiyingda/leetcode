package jyd.leet;

import java.util.Arrays;

/**
 * @author jiyingda
 * @date 2019/8/10
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet16 {

    public static void main(String[] args){

        int[] numx = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(numx, -5));;

    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(len <= 3){
            int re = 0;
            for(int n : nums){
                re += n;
            }
            return re;
        }
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] >= target){ return nums[0] + nums[1] + nums[2];}
        if(nums[len-1] + nums[len-2] + nums[len-3] <= target){
            return nums[len-1] + nums[len-2] + nums[len-3];
        }
        Integer min = null;
        Integer max = null;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int ab = nums[i] + nums[j];
                for(int k = len - 1; k > j; k--){
                    int abc = ab + nums[k];
                    if(abc == target){
                        return abc;
                    }
                    if(abc < target){
                        if(min == null || min < abc){
                            min = abc;
                        }
                        break;
                    }

                    if(max == null || max > abc){
                        max = abc;
                    }
                    /** 跳过重复的 */
                    while (k > j && nums[k] == nums[k - 1]){
                        k--;
                    }
                }
                /** 跳过重复的 */
                while (j + 1 < len && nums[j] == nums[j + 1]){
                    j++;
                }
            }
            /** 跳过重复的 */
            while (i + 1 < len && nums[i] == nums[i + 1]){
                i++;
            }

        }
        if(min == null){
            return max;
        }
        if(max == null){
            return min;
        }
        if((target - min) < (max - target)){
            return min;
        } else {
            return max;
        }

    }
}
