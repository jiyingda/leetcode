package com.jiyingda.ms;

import com.jiyingda.entity.ListNode;

/**
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/29 14:04
 */
public class M0202 {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.print(kthToLast(n1, 5));
    }

    public static int kthToLast(ListNode head, int k) {
        if(head == null){
            return 0;
        }
        ListNode kNode = head;
        while (head.next != null) {
            head = head.next;
            k--;
            if(k <= 0){
                kNode = kNode.next;
            }
        }
        return kNode.val;

    }
}
