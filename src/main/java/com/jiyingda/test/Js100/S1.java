/**
 * @(#)S1.java, 3月 18, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.Js100;

/**
 * @author jiyingda
 */
public class S1 {
    public static void main(String[] args) {
        int k = distMoney(16, 2);
        System.out.print(k);

    }

    public static int distMoney(int money, int children) {
        if (money - children < 0) {
            return -1;
        }
        if (money - children < 7) {
            return 0;
        }
        int n = money - children;
        int k = n / 7;
        int s = n % 7;
        if (k > children) {
            return children - 1;
        }
        if (k == children && s == 0) {
            return children;
        }
        if (k == children && s > 0) {
            return children - 1;
        }
        if (s == 3 && children - k == 1) {
            return k - 1;
        }
        return k;
    }
}