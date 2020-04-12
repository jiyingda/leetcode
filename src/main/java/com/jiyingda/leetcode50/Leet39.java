package com.jiyingda.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/2/4.
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet39 {

    public static void main(String[] args){
        int[] candidates = {5,3,2};
        List<List<Integer>> reList = combinationSum(candidates, 8);
System.out.println("ss");
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> reList = new ArrayList<>();
        combinationSum(candidates, target, 0,candidates.length, new ArrayList<>(), 0, reList);
        return reList;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int st, int idx, List<Integer> list, int tmpSum, List<List<Integer>> reList) {
        for(int j = st; j < idx; j++){
            if(candidates[j] + tmpSum > target){
                break;
            } else if(candidates[j] + tmpSum == target){
                list.add(candidates[j]);
                reList.add(list);
                break;
            } else {
                List<Integer> ttmpList = new ArrayList<>(list);
                ttmpList.add(candidates[j]);
                combinationSum(candidates, target,j, idx, ttmpList, tmpSum + candidates[j], reList);
            }
        }

        return null;
    }
}
