/**
 * @(#)Offer55.java, 10月 11, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  . Use is subject to license terms.
 */
package com.jiyingda.offer;


/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 */
public class Offer55 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        Offer55 offer55 = new Offer55();
        int len = offer55.maxDepth(null);
        System.out.println(isBalanced(n1));
        System.out.println(len);
    }

    public static boolean isBalanced(TreeNode root) {
        int len = treeLen(root);
        return len >= 0;
    }

    public static int treeLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = treeLen(root.left);
        if (l < 0) {
            return -1;
        }
        int r = treeLen(root.right);
        if (r < 0) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }


    public int maxDepth(TreeNode root) {
        max = 0;
        maxDepth(root, 0);
        return max;
    }
    int max = 0;
    public void maxDepth(TreeNode root, int len) {
        if (root == null) {
            if (len > max) {
                max = len;
            }
            return;
        }
        len++;
        maxDepth(root.left, len);
        maxDepth(root.right, len);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}