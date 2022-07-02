/**
 * @(#)Leet437.java, 3月 21, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

import com.jiyingda.tree.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiyingda
 */
public class Leet437 {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;
        Leet437 leet437 = new Leet437();
        leet437.pathSum(n1, 8);
    }

    int max = 0;
    public int pathSum(TreeNode root, int targetSum) {
        ddfs(root, targetSum);
        return max;

    }
    public void ddfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        dfs(root, targetSum);
        ddfs(root.left, targetSum);
        ddfs(root.right, targetSum);
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum - root.val == 0) {
            max++;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val);
        }
    }
}