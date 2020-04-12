package com.jiyingda.leetcode;
import com.jiyingda.entity.ListNode;

/**
 * @author jiyingda.
 * @date 2019/7/30.
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Leet206 {

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;
        ListNode re = reverseList(head1);
        System.out.println(re);

    }



    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode re = new ListNode(head.val);
        while (head.next != null){
            head = head.next;
            ListNode tmp = new ListNode(head.val);
            tmp.next = re;
            re = tmp;
        }
        return re;
    }
}
