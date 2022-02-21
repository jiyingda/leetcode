/**
 * @(#)Leet1414.java, 2月 03, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet1414 {

    public static void main(String[] args) {
        Leet1414 leet1414 = new Leet1414();
        System.out.print(leet1414.findMinFibonacciNumbers(6));
    }

    public int findMinFibonacciNumbers(int k) {
        all = 0;
        List<Integer> list = fb(k);
        return ttt(list, k, new ArrayList<>(), list.size() - 2);

    }
    public static int all = 0;

    public int ttt(List<Integer> list, int k, List<Integer> current, int i) {
        if (i < 0) {
            return -1;
        }
        int m = list.get(i);
        if (all + m == k) {
            current.add(m);
            return current.size();
        }
        if (all + m < k) {
            current.add(m);
            all += m;
            int j = ttt(list, k, current, i - 1);
            if (j > 0) {
                return j;
            }
            current.remove(current.size() - 1);
            return -1;
        } else {
            return ttt(list, k, current, i - 1);
        }
    }

    public List<Integer> fb(int k) {
        List<Integer> list = new ArrayList<>();
        int f1 = 1;
        int f2 = 2;
        list.add(f1);
        list.add(f2);
        while (f1 < k) {
            int t = f1 + f2;
            f1 = f2;
            f2 = t;
            list.add(t);
        }
        return list;
    }
}