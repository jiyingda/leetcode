/**
 * @(#)Leet450.java, 6月 02, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import com.jiyingda.tree.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 *
 * 输入: root = [], key = 0
 * 输出: []
 *  
 *
 * 提示:
 *
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet450 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        n5.right = n6;
        TreeNode nn = deleteNode(n1, 3);
        System.out.println(nn);

    }

    private static TreeNode pre;

    public static TreeNode deleteNode(TreeNode root, int key) {
        pre = root;
        TreeNode node = find(root, key);
        if (node == null) {
            return root;
        }
        if (node == root) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode left = findLeft(root.right);
            left.left = root.left;
            return root.right;
        }
        if (node.val < pre.val) {
            if (node.left == null) {
                pre.left = node.right;
                return root;
            }
            if (node.right == null) {
                pre.left = node.left;
                return root;
            }
            TreeNode left = findLeft(node.right);
            left.left = node.left;
            pre.left = node.right;
            return root;
        } else {
            if (node.left == null) {
                pre.right = node.right;
                return root;
            }
            if (node.right == null) {
                pre.right = node.left;
                return root;
            }
            TreeNode left = findLeft(node.right);
            left.left = node.left;
            pre.right = node.right;
            return root;
        }
    }

    public static TreeNode findLeft(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findLeft(root.left);
    }



    public static TreeNode find(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return root;
        }
        pre = root;
        if (key < root.val) {
            return find(root.left, key);
        }
        return find(root.right, key);
    }
}
