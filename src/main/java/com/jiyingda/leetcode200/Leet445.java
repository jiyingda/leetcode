package com.jiyingda.leetcode200;

import com.jiyingda.entity.ListNode;

/**
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/29 14:22
 */
public class Leet445 {
    public static void main(String[] args) {
        ListNode r1 = new ListNode(7);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(4);
        ListNode r4 = new ListNode(3);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        n1.next = n2;
        n2.next = n3;
        ListNode node = addTwoNumbers(r1, n1);
        System.out.print(node);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        int len1 = 0;
        int len2 = 0;
        while (ll1.next != null) {
            len1++;
            ll1 = ll1.next;
        }
        while (ll2.next != null) {
            len2++;
            ll2 = ll2.next;
        }
        ListNode root = new ListNode(0);
        ListNode node = new ListNode(0);
        int len = 0;
        if(len1 >= len2){
            root.next = l1;
            len = len1 - len2;
            node.next = l2;
        } else {
            root.next = l2;
            len = len2 - len1;
            node.next = l1;
        }
        sumTwoNum(root, node, len);

        return root.val == 0 ? root.next : root;
    }

    public static int sumTwoNum(ListNode root, ListNode node, int len){
        if(root == null){
            return 0;
        }
        if(len > 0){
            int c = sumTwoNum(root.next, node, len-1);
            int sum = root.val + c;
            int r = 0;
            if(sum >= 10){
                sum = sum - 10;
                r = 1;
            }
            root.val = sum;
            return r;
        }

        int c = sumTwoNum(root.next, node.next, 0);
        int sum = root.val + node.val + c;
        int r = 0;
        if(sum >= 10){
            sum = sum - 10;
            r = 1;
        }
        root.val = sum;
        return r;
    }

}
