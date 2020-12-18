package com.jiyingda.leetcode150;

import com.jiyingda.entity.ListNode;

/**
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/18.
 */
public class Leet148 {

    public static void main(String[] args){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode node = sortList(n1);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }


    public static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode idx = head;
        int len = 0;
        while (idx != null) {
            idx = idx.next;
            len ++;
        }

        return sortList(head, len);

    }

    public static ListNode sortList(ListNode head, int len) {
        if(len <= 1){
            return head;
        }
        int leftLen = len / 2;
        int rightLen = len - leftLen;
        ListNode left = head;
        for(int i = 0; i < leftLen-1; i++){
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        ListNode a = sortList(left, leftLen);
        ListNode b = sortList(right, rightLen);

        return merge(a, b);
    }

    public static ListNode merge(ListNode a, ListNode b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        ListNode c = new ListNode(0);
        ListNode d = c;
        while (a != null && b != null) {
            ListNode tmp = null;
            if(a.val < b.val){
                tmp = a;
                a = a.next;
            } else {
                tmp = b;
                b = b.next;
            }
            tmp.next = null;
            c.next = tmp;
            c = c.next;
        }
        if (a != null) {
            c.next = a;
        }
        if (b != null) {
            c.next = b;
        }

        return d.next;
    }
}
