/**
 * @(#)Leet401.java, 4月 09, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet401 {
    public static void main(String[] args) {
        Leet401 leet401 = new Leet401();
        PrintUtils.printArray(leet401.readBinaryWatch(9));

    }

    public List<String> readBinaryWatch(int turnedOn) {
        int[] d = new int[10];
        List<String> list = new ArrayList<>();
        dfs(turnedOn, d, 0, list);
        return list;
    }

    private void dfs(int turnedOn, int[] current, int i, List<String> list) {
        if (turnedOn < 0 || i >= 10) {
            return;
        }
        if (turnedOn  == 0) {
            String s = ddd(current);
            if (!"".equals(s)) {
                list.add(s);
            }
            return;
        }

        for (int j = i; j < 10; j++) {
            current[j] = 1;
            dfs(turnedOn - 1, current, j + 1, list);
            current[j] = 0;
        }
    }

    private String ddd(int[] s) {
        int k = s[0] + s[1] * 2 + s[2] * 4 + s[3] * 8;
        int j = s[4] + s[5] * 2 + s[6] * 4 + s[7] * 8 + s[8] * 16 + s[9] * 32;
        if (k > 12 || j > 59) {
            return "";
        }
        if (k == 0 && j == 0) {
            return "";
        }
        return j < 10 ? k + ":0" + j : k + ":" + j;
    }
}