/**
 * @(#)Leet1447.java, 2月 10, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Leet1447 {
    public static void main(String[] args) {
        Leet1447 leet1447 = new Leet1447();
        leet1447.simplifiedFractions(3);
    }


    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add("1/" + i);
            for (int j = 2; j < i; j++) {
                if (gcd(j, i) == 1) {
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
