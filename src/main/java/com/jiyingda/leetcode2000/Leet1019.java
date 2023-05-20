/**
 * @(#)Leet1019.java, 4月 10, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.entity.ListNode;
import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet1019 {
    public static void main(String[] args) {
        Leet1019 leet1019 = new Leet1019();
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        int[] re = leet1019.nextLargerNodes(n1);
        PrintUtils.printArray(re);

    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Deque<int[]> deque = new LinkedList<>();
        int i = 0;
        while (head != null) {
            list.add(0);
            while (!deque.isEmpty() && deque.peekLast()[0] < head.val) {
                list.set(deque.pollLast()[1], head.val);
            }
            deque.offer(new int[]{head.val, i});
            i++;
            head = head.next;
        }
        int[] re = new int[i];
        for (int j = 0; j < i; j++) {
            re[j] = list.get(j);
        }
        return re;

    }
}