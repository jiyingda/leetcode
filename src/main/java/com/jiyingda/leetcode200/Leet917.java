/**
 * @(#)Leet917.java, 2月 23, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

/**
 * @author jiyingda
 */
public class Leet917 {

    public static void main(String[] args) {
        Leet917 leet917 = new Leet917();
        System.out.println(leet917.reverseOnlyLetters("ab-cd"));

    }

    public String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !isEng(array[left])) {
                left++;
            }
            while (left < right && !isEng(array[right])) {
                right--;
            }
            swap(array, left, right);
            left++;
            right--;
        }
        return new String(array);
    }

    public void swap(char[] array, int i, int j) {
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public boolean isEng(char c) {
        if (c - 'a' >= 0 && c - 'a' < 26) {
            return true;
        }
        if (c - 'A' >= 0 && c - 'A' < 26) {
            return true;
        }
        return false;
    }
}