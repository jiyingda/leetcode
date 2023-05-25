/**
 * @(#)Leet1373.java, 5月 20, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.tree.TreeNode;

/**
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 * 二叉搜索树的定义如下：
 *
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 *
 *
 *
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 *
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 *
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 *
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 *
 *
 * 提示：
 *
 * 每棵树有 1 到 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 *
 * @author jiyingda
 */
public class Leet1373 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);

        TreeNode n31 = new TreeNode(2);
        TreeNode n32 = new TreeNode(5);
        TreeNode n321 = new TreeNode(4);
        TreeNode n322 = new TreeNode(6);

        n1.left = n2;
        n2.left = n4;
        n2.right = n5;
        n1.right = n3;
        n3.left = n31;
        n3.right = n32;
        n32.left = n321;
        n32.right = n322;


        Leet1373 leet1373 = new Leet1373();
        int a = leet1373.maxSumBST(n1);
        System.out.print(a);

    }

    public int maxSumBST(TreeNode root) {
        max = 0;
        dfs(root);
        return max;

    }
    private static int max = 0;

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return new int[]{root.val, root.val, root.val};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (left != null && right == null) {
            if (left[0] <= left[1] && left[1] < root.val) {
                int all = root.val + left[2];
                max = Math.max(max, all);
                return new int[]{left[0], root.val, all};
            }
            return new int[]{1, 0, 0};
        }
        if (left == null && right != null) {
            if (right[0] <= right[1] && root.val < right[0]) {
                int all = root.val + right[2];
                max = Math.max(max, all);
                return new int[]{root.val, right[1], all};
            }
            return new int[]{1, 0, 0};
        }
        if (left[0] <= left[1] && left[1] < root.val && right[0] <= right[1] && root.val < right[0]) {
            int all = root.val + right[2] + left[2];
            max = Math.max(max, all);
            return new int[]{left[0], right[1], all};
        }
        return new int[]{1, 0, 0};
    }
}