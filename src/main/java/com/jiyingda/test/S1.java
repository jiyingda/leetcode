/**
 * @(#)S1.java, 1月 23, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiyingda
 */
public class S1 {

    public static void main(String[] args) {
        int[] A = new int[] {1,2,-3, -4, 3,-1,-2};
        System.out.print(solution(A));


    }

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int a : A) {
            if (set.contains(-a)) {
                int b = Math.abs(a);
                if (b > max) {
                    max = b;
                }
            } else {
                set.add(a);
            }
        }
        return max;
    }
}