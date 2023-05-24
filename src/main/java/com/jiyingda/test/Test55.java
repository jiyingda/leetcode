/**
 * @(#)Test55.java, 5月 09, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.test;

import com.jiyingda.entity.ListNode;

/**
 * @author jiyingdabj
 */
public class Test55 {

    public static void main(String[] args) {
        String s = "0123456789";
        String b = "最后我们班以26枚金牌，荣获全年级第一。";
        System.out.println(s.substring(0, 0 + 5));

    }

    public ListNode reverseList(ListNode head) {
        ListNode re = new ListNode(0);
        while (head != null) {
            ListNode t = head;
            head = head.next;
            t.next = re.next;
            re.next = t;

        }
        return re.next;

    }
}
