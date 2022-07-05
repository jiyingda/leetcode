package com.jiyingda.leetcode500;

import com.jiyingda.entity.ListNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/25 23:40
 */
public class Leet328 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //n5.next = n6;
        ListNode node = oddEvenList(n1);
        System.out.print(node);
    }


    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode j = head;
        ListNode oo = new ListNode(0);
        ListNode o = oo;
        while (head.next != null) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            if(head.next != null){
                head = head.next;
            }
            tmp.next = null;
            oo.next = tmp;
            oo = oo.next;
        }
        head.next = o.next;
        return j;
    }
}
