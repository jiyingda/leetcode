/**
 * @(#)Leet515.java, 3月 21, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            while(size > 0) {
                TreeNode t = que.poll();
                if (t.left != null) {
                    que.offer(t.left);
                }
                if (t.right != null) {
                    que.offer(t.right);
                }
                max = Math.max(max, t.val);
                size--;
            }
            list.add(max);
        }
        return list;
    }
}