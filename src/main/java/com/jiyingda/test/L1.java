/**
 * @(#)L1.java, 2月 08, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class L1 {

    public static void main(String[] args) {
        System.out.print(solution(3));
    }

    public static int[] solution(int N) {
        int[] r = new int[N];
        int p = 1;
        int len = N;
        if (N % 2 == 1) {
            r[len - 1] = 0;
            len--;
        }
        int i = 0;
        while (i < len) {
            r[i] = p;
            r[i + 1] = -p;
            p++;
            i = i + 2;
        }
        return  r;
    }
}