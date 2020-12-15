package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

/**
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/15.
 */
public class Leet112 {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        System.out.print(hasPathSum(n1, 23));;

    }



    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        if(root.left != null){
            boolean leftFlag = hasPathSum(root.left, sum-root.val);
            if(leftFlag){
                return true;
            }
        }
        if(root.right != null){
            boolean rightFlag = hasPathSum(root.right, sum-root.val);
            if(rightFlag){
                return true;
            }
        }
        return false;
    }
}
