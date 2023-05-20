/**
 * @(#)Leet1026.java, 4月 18, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;


import com.jiyingda.tree.TreeNode;

/**
 * @author jiyingda
 */
public class Leet1026 {
    public static void main(String[] args) {
        // 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(14);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(13);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n5.right = n8;
        n3.right = n6;
        n6.left = n9;
        Leet1026 leet1026 = new Leet1026();
        int m = leet1026.maxAncestorDiff(n1);
        System.out.print(m);

    }

    private static int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        max = 0;
        if (root == null) {
            return max;
        }
        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode node) {
        int m = node.val;
        int n = node.val;
        if (node.left != null) {
            int[] a = dfs(node.left);
            max = Math.max(max, Math.abs(node.val - a[0]));
            max = Math.max(max, Math.abs(node.val - a[1]));
            n = Math.min(n, a[0]);
            m = Math.max(m, a[1]);

        }
        if (node.right != null) {
            int[] a = dfs(node.right);
            max = Math.max(max, Math.abs(node.val - a[0]));
            max = Math.max(max, Math.abs(node.val - a[1]));
            n = Math.min(n, a[0]);
            m = Math.max(m, a[1]);
        }
        return new int[]{n, m};
    }
}