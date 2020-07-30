package com.jiyingda.leetcode150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiyingda.
 * @date 2020/7/30.
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leet104 {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        //n1.left = n2;
        //n1.right = n3;
        //n3.left = n4;
        //n4.right = n5;
        System.out.println(maxDepth(n1));;

    }


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int maxDepth = 0;
        if (root.left != null) {
            maxDepth = Math.max(maxDepth, maxDepth(root.left));
        }
        if (root.right != null) {
            maxDepth = Math.max(maxDepth, maxDepth(root.right));
        }
        return maxDepth + 1;

    }

    public static int maxDepths(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int i = 0;
        while (!queue.isEmpty()){
            TreeNode a = queue.poll();
            if(a == null){
                i++;
                if(queue.isEmpty()){
                    return i;
                }
                queue.add(null);
            } else {
                if(a.left != null){
                    queue.add(a.left);
                }
                if(a.right != null){
                    queue.add(a.right);
                }
            }


        }
        return i;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
