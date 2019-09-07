package com.jiyingda.Leetcode;

public class Leet2 {
    public static void main(String... args){
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        l1.next = l11;

        ListNode l2 = new ListNode(4);
        ListNode l13 = new ListNode(2);
        ListNode l14 = new ListNode(2);
        l13.next = l14;
        l2.next = l13;
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode {
     int val;
    ListNode next;
     ListNode(int x) { val = x; }
 }