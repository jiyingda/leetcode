/**
 * @(#)M0403.java, 3月 19, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.ms;

import com.jiyingda.entity.ListNode;
import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiyingda
 */
public class M0403 {


    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        que.add(tree);
        while (!que.isEmpty()) {
            int size = que.size();
            TreeNode t = que.poll();
            ListNode root = new ListNode(t.val);
            list.add(root);
            if (t.left != null) {
                que.offer(t.left);
            }
            if (t.right != null) {
                que.offer(t.right);
            }
            while (size > 1) {
                TreeNode temp = que.poll();
                ListNode tempNode = new ListNode(temp.val);
                root.next = tempNode;
                root = root.next;
                size--;
                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
            }

        }
        ListNode[] re = new ListNode[list.size()];
        int i = 0;
        for (ListNode n : list) {
            re[i] = n;
            i++;
        }
        return re;

    }
}