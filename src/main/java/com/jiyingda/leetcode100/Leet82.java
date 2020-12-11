package com.jiyingda.leetcode100;

import com.jiyingda.entity.ListNode;

/**
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/10.
 */
public class Leet82 {

    public static void main(String[] args){

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        /*n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;*/
        n1.next = n2;
        ListNode h = deleteDuplicates(n1);
        while (h != null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }

    }


    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode reHead = new ListNode(0);
        ListNode rrr = reHead;
        reHead.next = head;
        while (reHead.next != null && reHead.next.next != null) {
            if(reHead.next.val == reHead.next.next.val) {
                ListNode tmp = reHead.next.next.next;
                while (tmp != null && tmp.val == reHead.next.val) {
                    tmp = tmp.next;
                }
                reHead.next = tmp;
            } else {
                reHead = reHead.next;
            }
        }
        return rrr.next;
    }
}
