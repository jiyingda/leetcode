/**
 * @(#)Leet1763.java, 2月 01, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiyingda
 */
public class Leet1763 {

    public static void main(String[] args) {
        System.out.print(longestNiceSubstring("xLeElzxgHzcWslEdgMGwEOZCXwwDMwcEhgJHLL"));;
    }

    public static String longestNiceSubstring(String s) {
        /*YazaAay
        ----140
        64-45--

        abABB
        --011
        20---*/
        Map<Character, Integer> lMap = new HashMap<>();
        Map<Character, Integer> rMap = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!lMap.containsKey(ch[i])) {
                lMap.put(ch[i], i);
            }
            rMap.put(ch[i], i);
        }
        int[] ll = new int[ch.length];
        int[] rr = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            char chh = upperOrLower(ch[i]);
            Integer lm = lMap.get(chh);
            if (lm == null) {
                ll[i] = '-';
            } else if (i >= lm) {
                ll[i] = lm;
            } else {
                ll[i] = '-';
            }
            Integer rm = rMap.get(chh);
            if (rm == null) {
                rr[i] = '-';
            } else if (rm >= i) {
                rr[i] = rm;
            } else {
                rr[i] = '-';
            }
        }
        int left = 0;
        int right = ch.length - 1;
        int max = 0;
        String maxStr = "";
        StringBuilder sb = new StringBuilder();
        fff(ll, rr, left, right);
        int current = 0;
        for (int i = 0; i < ll.length; i++) {
            if (ll[i] == '-' && rr[i] == '-') {
                if (max < current) {
                    maxStr = sb.toString();
                    sb = new StringBuilder();
                }
                max = Math.max(max, current);
                current = 0;
            } else {
                current++;
                sb.append(ch[i]);
            }
        }
        if (max < current) {
            maxStr = sb.toString();
            max = current;
        }
        if (max <= 1) {
            return "";
        }
        return maxStr;
    }

    private static void fff (int[] ll, int[] rr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        while (i <= right) {
            if ((ll[i] < left || ll[i] > right)) {
                ll[i] = '-';
            }
            if ((rr[i] < left || rr[i] > right)) {
                rr[i] = '-';
            }
            if (ll[i] == '-' && rr[i] == '-') {
                fff(ll, rr, left, i - 1);
                fff(ll, rr, i + 1, right);
                break;
            }
            i++;
        }

    }

    private static char upperOrLower(char c) {
        if (Character.isUpperCase(c)) {
            return Character.toLowerCase(c);
        } else {
            return Character.toUpperCase(c);
        }
    }
}