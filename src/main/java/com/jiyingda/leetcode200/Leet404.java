package com.jiyingda.leetcode200;

import com.jiyingda.tree.TreeNode;

/**
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2021/2/16
 */
public class Leet404 {

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
        System.out.println(sumOfLeftLeaves(n1));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return travel(root.left, true) + travel(root.right, false);
    }
    public static int travel(TreeNode root, boolean isLeft){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        return travel(root.left, true) + travel(root.right, false);
    }
}
