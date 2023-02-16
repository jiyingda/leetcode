/**
 * @(#)Offer077.java, 7月 04, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import com.jiyingda.entity.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
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
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/7WHec2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Offer077 {

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort(Comparator.comparing(e -> e.val));
        ListNode hair = new ListNode(0);
        ListNode idx = hair;
        for (ListNode a : list) {
            idx.next = a;
            idx = idx.next;
        }
        idx.next = null;
        return hair.next;
    }
}
