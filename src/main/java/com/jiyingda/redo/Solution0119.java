/**
 * @(#)Solution0119.java, 1月 19, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import com.jiyingda.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * @author jiyingda
 */
public class Solution0119 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;
        ListNode[] lists = new ListNode[]{a1, b1};
        ListNode d = mergeKLists(lists);
        while (d != null) {
            System.out.print(d.val + " -> ");
            d = d.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len < 1) {
            return null;
        }
        if (len < 2) {
            return lists[0];
        }
        int middle = len;
        while (middle > 1) {
            int left = 0;
            int right = middle - 1;
            while (left < right) {
                lists[left] = merge(lists[left], lists[right]);
                left++;
                right--;
            }
            middle = middle / 2 + (middle % 2 == 0 ? 0 : 1);
        }

        return lists[0];
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