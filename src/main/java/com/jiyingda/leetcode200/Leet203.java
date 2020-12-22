package com.jiyingda.leetcode200;

import com.jiyingda.entity.ListNode;

/**
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author jiyingda
 * @date 2020/12/22 23:21
 */
public class Leet203 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode node = removeElements(n1, 1);
        System.out.print(node);

    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode re = new ListNode(0);
        re.next = head;
        ListNode rrr = re;
        while (re.next != null) {
            if(re.next.val == val){
                re.next = re.next.next;
            } else {
                re = re.next;
            }
        }
        return rrr.next;
    }
}
