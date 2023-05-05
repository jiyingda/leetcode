/**
 * @(#)T3.java, 4月 21, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingdabj
 */
public class T3 {

    public static void main(String[] args) {
        String u = "YFDA11001213L50000060";
        String penultimate = u.substring(u.length() - 2, u.length() - 1);
        int mod = Integer.parseInt(penultimate) % 2;
        System.out.println(penultimate);
        System.out.println(mod);
    }
}
