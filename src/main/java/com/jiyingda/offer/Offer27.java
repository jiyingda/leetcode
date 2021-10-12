/**
 * @(#)Offer27.java, 10月 12, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingda
 */
public class Offer27 {

    public static void main(String[] args) {
        TreeNode n1 = new  TreeNode(3);
        TreeNode n2 = new  TreeNode(9);
        TreeNode n3 = new  TreeNode(20);
        TreeNode n4 = new  TreeNode(15);
        TreeNode n5 = new  TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        TreeNode node = mirrorTree(n1);
        System.out.println(node);

    }

    public static TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        mirrorTree(root.left);
        mirrorTree(root.right);
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}