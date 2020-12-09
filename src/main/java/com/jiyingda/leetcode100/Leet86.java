package com.jiyingda.leetcode100;

import com.jiyingda.entity.ListNode;

/**
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/9.
 */
public class Leet86 {

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        ListNode re = partition(n6, 3);
        while (re != null){
            System.out.print(re.val + " -> ");
            re = re.next;
        }


    }


    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode big = new ListNode(0);
        ListNode bigH = big;
        ListNode re = new ListNode(0);
        re.next = head;
        ListNode reHead = re;
        while (re.next != null){
            if(re.next.val < x){
                re = re.next;
            } else {
                big.next = re.next;
                re.next = re.next.next;
                big.next.next = null;
                big = big.next;
            }
        }
        re.next = bigH.next;
        return reHead.next;
    }
}
