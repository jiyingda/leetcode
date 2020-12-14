package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

/**
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *  
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/14.
 */
public class Leet110 {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n5.right = n8;
        System.out.print(isBalanced(n1));;


    }



    public static boolean isBalanced(TreeNode root) {
        int a = getHeight(root);
        return a >= 0;
    }


    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int a = getHeight(root.left);
        if(a < 0){
            return -1;
        }
        int b = getHeight(root.right);
        if(b < 0 || Math.abs(a-b) > 1){
            return -1;
        }
        return Math.max(a, b) + 1;
    }
}
