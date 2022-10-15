/**
 * @(#)M0204.java, 3月 21, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.ms;

import com.jiyingda.entity.ListNode;

/**
 * @author jiyingdabj
 */
public class M0204 {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode l = left;
        ListNode r = right;
        while (head != null) {
            ListNode temp = head;
            if (head.val < x) {
                l.next = temp;
                l = l.next;
            } else {
                r.next = temp;
                r = r.next;
            }
            head = head.next;
            temp.next = null;
        }
        l.next = right.next;

        return left.next;
    }
}
