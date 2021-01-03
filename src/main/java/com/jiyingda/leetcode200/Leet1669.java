package com.jiyingda.leetcode200;

import com.jiyingda.entity.ListNode;

/**
 *
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 *
 * 请你返回结果链表的头指针。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 *
 *
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *  
 *
 * 提示：
 *
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2021/1/3 16:17
 */
public class Leet1669 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode b1 = new ListNode(10);
        ListNode b2 = new ListNode(20);
        ListNode b3 = new ListNode(30);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        b1.next = b2;
        b2.next = b3;
        ListNode node = mergeInBetween(a1, 3,4, b1);
        System.out.print(node);

    }


    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode re = list1;
        b = b-a;
        while (a > 1) {
            list1 = list1.next;
            a--;
        }
        ListNode tmpA = list1;
        while (b >= 0) {
            list1 = list1.next;
            b--;
        }
        tmpA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1.next;
        return re;
    }
}
