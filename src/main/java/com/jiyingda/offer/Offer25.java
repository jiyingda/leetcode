/**
 * @(#)Offer25.java, 8月 08, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import com.jiyingda.entity.ListNode;

/**
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 示例1：
 *
 *
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *  
 *
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lMSNwu
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer25 {

    public static void main(String[] args) {

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