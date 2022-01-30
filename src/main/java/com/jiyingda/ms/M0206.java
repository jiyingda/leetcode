/**
 * @(#)M0206.java, 1月 30, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.ms;

import com.jiyingda.entity.ListNode;

import java.util.Stack;

/**
 * @author jiyingda
 */
public class M0206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        node2.next = node3;
        node1.next = node2;
        node3.next = node4;
       // node4.next = node5;

        System.out.print(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        Stack<Integer> stack = new Stack<>();
        while (first != null) {
            first = first.next;
            if (first != null) {
                first = first.next;
            } else {
                second = second.next;
                break;
            }
            stack.add(second.val);
            second = second.next;
        }
        while (second != null) {
            if (second.val != stack.pop()) {
                return false;
            }
            second = second.next;
        }
        return true;

    }
}