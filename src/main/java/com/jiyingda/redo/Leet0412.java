/**
 * @(#)Leet0412.java, 4月 12, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Leet0412 {

    public static void main(String[] args) {
        Leet0412 leet = new Leet0412();
        List<List<Integer>> list = leet.combinationSum(new int[]{1, 2}, 1);
        for (List<Integer> l : list) {
            PrintUtils.printArray(l);
            System.out.println();
        }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, candidates.length, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int i, int len, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i >= len) {
            return;
        }
        for (int k = i; k < len; k++) {
            if (candidates[k] > target) {
                break;
            }
            list.add(candidates[k]);
            dfs(candidates, k, len, target - candidates[k], list, res);
            list.remove(list.size() - 1);
        }
    }
}