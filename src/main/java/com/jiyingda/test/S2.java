/**
 * @(#)S2.java, 1月 24, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingda
 */
public class S2 {

    public static void main(String[] args) {
        //System.out.print(solution("azABaabza"));
        // ABaab
        //System.out.print(solution("aAzZ"));
        System.out.print(solution("azABaabza"));


    }


    public static int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.length() < 2) {
            return -1;
        }
        int[] l = new int[26];
        int[] u = new int[26];

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) < 91) {
                u[S.charAt(i) - 65]++;
            } else {
                l[S.charAt(i) - 97]++;
            }
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (l[i] == u[i] || l[i] > 0 && u[i] > 0) {
                continue;
            }
            if (l[i] > 0) {
                set.add((char)(i + 97));
            }
            if (u[i] > 0) {
                set.add((char)(i + 65));
            }
        }
        int max = S.length();
        if (set.size() == 0) {

            return max;
        }

        int left = 0;
        int right = 0;
        List<String> sss = new ArrayList<>();
        for (right = 0; right < S.length(); right++) {
            if (set.contains((char)S.charAt(right))) {
                sss.add(S.substring(left, right));
                left = right+1;
            }
        }
        for (String s : sss) {
            int tempMax = solution(s);
            if (tempMax > 0) {
                max = Math.min(max, tempMax);
            }
        }
        return max;
    }
}