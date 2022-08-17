/**
 * @(#)Offer25s.java, 9月 28, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import com.jiyingda.entity.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer25s {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l11.next = l12;
        l1.next = l11;
        l21.next = l22;
        l2.next = l21;

        ListNode nn = mergeTwoLists(l1, null);
        System.out.println(nn);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode idx = new ListNode(0);
        ListNode re = idx;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                idx.next = l1;
                l1 = l1.next;
            } else {
                idx.next = l2;
                l2 = l2.next;
            }
            idx = idx.next;
        }
        if (l1 != null) {
            idx.next = l1;
        }
        if (l2 != null) {
            idx.next = l2;
        }
        return re.next;
    }


}