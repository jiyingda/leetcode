/**
 * @(#)Solution011902.java, 1月 19, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import com.jiyingda.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Solution011902 {
    public static void main(String[] args) {
        // 4,2,1,3
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode d = sortList(a1);
        while (d != null) {
            System.out.print(d.val + " -> ");
            d = d.next;
        }

    }

    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode l1 = sortList(head, slow);
        ListNode l2 = sortList(slow, tail);
        return merge(l1, l2);
    }


    public static ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode c = new ListNode(0);
        ListNode r = c;
        while (a != null && b != null) {
            if (b.val < a.val) {
                c.next = b;
                b = b.next;
                c = c.next;
            } else {
                c.next = a;
                a = a.next;
                c = c.next;
            }
        }
        if (a != null) {
            c.next = a;
        }
        if (b != null) {
            c.next = b;
        }
        return r.next;
    }
}