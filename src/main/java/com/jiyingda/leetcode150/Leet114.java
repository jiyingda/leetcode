package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

/**
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/15.
 */
public class Leet114 {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        flatten(n1);
        System.out.print(n1);

    }



    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            flatten(root.left);
        }
        if(root.right != null){
            flatten(root.right);
        }
        if(root.left != null){
            TreeNode r = root.left;
            while (r.right != null) {
                r = r.right;
            }
            r.right = root.right;
            root.right = root.left;
            root.left = null;
        }

    }
}
