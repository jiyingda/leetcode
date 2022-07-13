/**
 * @(#)PrintUtils.java, 7月 06, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.util;

import com.jiyingda.entity.ListNode;

import java.util.List;

/**
 * @author jiyingdabj
 */
public class PrintUtils {

    public static void printArray(int[] array) {
        for (int b : array) {
            System.out.print(b + "\t");
        }
    }

    public static void printArray(List<Integer> array) {
        for (int b : array) {
            System.out.print(b + "\t");
        }
    }

    public static void printArray(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
    }
}
