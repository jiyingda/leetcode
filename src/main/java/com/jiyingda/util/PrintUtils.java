/**
 * @(#)PrintUtils.java, 7月 06, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.util;

import com.jiyingda.entity.ListNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class PrintUtils {

    public static void main(String[] args) throws IOException {

    }

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
