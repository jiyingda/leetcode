package com.jiyingda.leetcode150;

import com.jiyingda.entity.ListNode;

/**
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/17.
 */
public class Leet143 {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n5;
        reorderList(n5);
    }

    public static void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode left = head;
        while (fast != null) {
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
        }
        ListNode rrr = new ListNode(0);
        ListNode right = slow.next;
        slow.next = null;

        while (right != null) {
            ListNode tmp = right;
            right = right.next;
            tmp.next = rrr.next;
            rrr.next = tmp;
        }
        right = rrr.next;
        ListNode res = left;
        while (right != null) {
            ListNode tmp = right;
            right = right.next;
            tmp.next = left.next;
            left.next = tmp;
            left = left.next.next;
        }

        head = res;
        System.out.print(fast + "" + slow + "" + rrr);

    }
}
