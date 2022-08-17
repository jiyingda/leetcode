/**
 * @(#)Leet336.java, 2月 23, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;


import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 */
public class Leet336 {

    public static void main(String[] args) {
        Leet336 leet336 = new Leet336();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        leet336.findLeaves(null);
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        while (root != null) {
            List<Integer> current = new ArrayList<>();
            root = dfs(root, current);
            list.add(current);
        }
        return list;
    }

    public TreeNode dfs(TreeNode root, List<Integer> current) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            current.add(root.val);
            return null;
        }
        if (root.left != null) {
            root.left = dfs(root.left, current);
        }
        if (root.right != null) {
            root.right = dfs(root.right, current);
        }
        return root;

    }
}