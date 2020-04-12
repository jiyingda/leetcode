package com.jiyingda.leetcode50;

import com.jiyingda.entity.ListNode;

/**
 * @author jiyingda.
 * @date 2019/9/14.
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet24 {

    public static void main(String[] args){

        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        ListNode re = swapPairs(h1);
        System.out.println(re);

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode re = null;
        ListNode ttt = null;
        while (head != null){
            ListNode temp = head.next;
            if(temp == null){
                if(re == null){
                    re = head;
                }
                break;
            }
            head.next = temp.next;
            temp.next = head;
            if(ttt != null){
                ttt.next = temp;
            }
            if(re == null){
                re = temp;
            }
            ttt = head;
            head = head.next;

        }

        return re;
    }
}
