/**
 * @(#)PrintUtils.java, 7月 06, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.util;

import com.jiyingda.entity.ListNode;

import java.util.List;

/**
 * @author jiyingdabj
 */
public class PrintUtils {

    public static void main(String[] args) {
        System.out.println(1754894037648L - 1754894036497L);
    }

    public static void printArray(int[] array) {
        for (int b : array) {
            System.out.print(b + "\t");
        }
    }

    public static <T> void printArray(List<T> array) {
        for (T b : array) {
            System.out.print(b + "\t");
        }
    }

    public static <T> void printArray(T[] array) {
        for (T b : array) {
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
