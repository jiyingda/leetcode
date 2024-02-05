/**
 * @(#)Offer18.java, 10月 11, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.offer;

import com.jiyingda.entity.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 */
public class Offer18 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode node = deleteNode(null, 5);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }


    public static ListNode deleteNode(ListNode head, int val) {
        ListNode re = new ListNode(0);
        re.next = head;
        ListNode idx = re;
        while (head != null) {
            if (head.val == val) {
                idx.next = head.next;
                break;
            } else {
                head = head.next;
                idx = idx.next;
            }
        }
        return re.next;
    }
}