package com.jiyingda.leetcode50;

import com.jiyingda.entity.ListNode;

/**
 * @author jiyingda.
 * @date 2019/10/24.
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet25 {
    public static void main(String[] args){

        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        /*h2.next = h3;
        h3.next = h4;
        h4.next = h5;*/
        ListNode re = reverseKGroup(h1, 3);
        System.out.println(re);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        if(k < 2){
            return head;
        }
        ListNode result = null;
        ListNode re = null;
        ListNode temp = head;
        int i = 1;
        while (head != null){
            if(i >= k){
                ListNode next = head.next;
                head.next = null;
                temp = reverseList(temp);
                if(result == null){
                    result = temp;
                    re = result;
                } else {
                    re.next = temp;
                }
                while (re.next != null){
                    re = re.next;
                }
                head = next;
                temp = head;
                i = 1;
            } else {
                head = head.next;
                i++;
            }
        }
        if(re != null){
            re.next = temp;
        } else {
            result = temp;
        }

        return result;
    }


}
