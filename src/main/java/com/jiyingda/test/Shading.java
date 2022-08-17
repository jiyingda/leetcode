/**
 * @(#)Shading.java, 5月 07, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Shading {
    public static void main(String[] args) throws InterruptedException {
        long teacherId = 4465677;
        System.out.println("库：" + ((teacherId & 0xF) >> 3));
        System.out.println("表：" + ((teacherId & 0xF) >> 1));
        System.out.println(System.currentTimeMillis());
    }
}