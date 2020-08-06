package com.jiyingda.leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/8/6.
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet78 {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        subsets(nums);
        for(List<Integer> l : list){
            for(Integer i : l){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }


    static List<List<Integer>> list = new ArrayList<>();


    public static List<List<Integer>> subsets(int[] nums) {
        travel(0, nums, new ArrayList<>());
        return list;
    }


    public static void travel(int first,int[] nums, ArrayList<Integer> currentList){
        list.add(new ArrayList<>(currentList));
        for(int i = first; i < nums.length; i++){
            currentList.add(nums[i]);
            travel(i+1, nums, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
