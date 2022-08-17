/**
 * @(#)L2.java, 2月 08, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingda
 */
public class L2 {


    public static void main(String[] args) {
        L2 l2 = new L2();
        int k = l2.solution(1, 8, 3, 2);
        System.out.print(k);
    }


    public int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8

        List<Integer> nums = new ArrayList<>();
        nums.add(A);
        nums.add(B);
        nums.add(C);
        nums.add(D);

        List<List<Integer>> reList = new ArrayList<>();
        arrangeSelect(nums, new ArrayList<>(), 4, reList);
        int count = 0;
        for (List<Integer> list : reList) {
            if (check(list)) {
                count++;
            }
        }
        return count;
    }

    public boolean check(List<Integer> nums) {
        int a = nums.get(0) * 10 + nums.get(1);
        if (a > 23) {
            return false;
        }
        int b = nums.get(2) * 10 + nums.get(3);
        if (b > 59) {
            return false;
        }
        return true;
    }

    public void arrangeSelect(List<Integer> data, List<Integer> target, int k, List<List<Integer>> reList) {
        List<Integer> copyData;
        List<Integer> copyTarget;
        if(target.size() == k) {
            List<Integer> tmp = new ArrayList<>(target);
            reList.add(tmp);
        }
        Set<Integer> aa = new HashSet<>();

        for(int i=0; i<data.size(); i++) {
            if(aa.contains(data.get(i))){
                continue;
            }
            aa.add(data.get(i));
            copyData = new ArrayList<>(data);
            copyTarget = new ArrayList<>(target);

            copyTarget.add(copyData.get(i));
            copyData.remove(i);
            arrangeSelect(copyData, copyTarget,k, reList);
        }
    }
}