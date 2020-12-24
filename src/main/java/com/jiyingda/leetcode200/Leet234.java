package com.jiyingda.leetcode200;

import com.jiyingda.entity.ListNode;

/**
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/24 23:29
 */
public class Leet234 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.print(isPalindrome(n1));;

    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode idx = head;
        ListNode slow = idx;
        ListNode fast = idx;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        if(slow == null){
            return true;
        }
        ListNode newHead = new ListNode(0);
        while (slow != null) {
            ListNode tmp = slow;
            slow = slow.next;
            tmp.next = newHead.next;
            newHead.next = tmp;
        }
        newHead = newHead.next;
        while (newHead != null) {
            if(head.val == newHead.val){

            } else {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
}
