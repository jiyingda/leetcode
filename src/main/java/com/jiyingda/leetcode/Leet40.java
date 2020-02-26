package com.jiyingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiyingda
 * @date 2020/2/27
 */
public class Leet40 {

    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
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
                combinationSum(candidates, target,j+1, idx, ttmpList, tmpSum + candidates[j], reList);
            }
            while ((j+1) < idx && candidates[j+1] == candidates[j]){
                j++;
            }
        }

        return null;
    }
}
