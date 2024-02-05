/**
 * @(#)M0206.java, 10月 22, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.ms;

/**
 * @author jiyingda
 */
public class M0206 {


    public boolean isPalindrome(ListNode head) {
        int i = 0, j = 0;
        while (head != null) {
            i++;
            j++;
            head = head.next;
            if (head == null) {
                break;
            }
            head = head.next;
            j++;
        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}