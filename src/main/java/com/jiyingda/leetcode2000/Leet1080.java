/**
 * @(#)Leet1080.java, 5月 24, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.tree.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 *
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 *
 * 叶子节点，就是没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 *
 *
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 *
 *
 * 输入：root = [1,2,-3,-5,null,4,null], limit = -1
 * 输出：[1,null,-3,4]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 5000] 内
 * -105 <= Node.val <= 105
 * -109 <= limit <= 109
 *
 * @author jiyingdabj
 */
public class Leet1080 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(-5);
        TreeNode n5 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        Leet1080 l = new Leet1080();
        TreeNode r = l.sufficientSubset(n1, -1);
        System.out.println(r);

    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    public TreeNode dfs(TreeNode root, int current, int limit) {
        current += root.val;
        if (root.left == null && root.right == null) {
            if (current >= limit) {
                return root;
            }
            return null;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = dfs(root.left, current, limit);
        }
        if (root.right != null) {
            right = dfs(root.right, current, limit);
        }
        if (left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
