package com.jiyingda.leetcode100;

import com.jiyingda.leetcode150.Leet104;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda.
 * @date 2020/7/30.
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet94 {

    public static void main(String[] args){
        System.out.println(0 % 10);


        TreeNode n1 = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.right = n2;
        n2.left = n3;
        inorderTraversal(n1);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        aaa(root, list);
        return list;
    }

    private static void aaa(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        aaa(node.left, list);
        list.add(node.val);
        aaa(node.right, list);
    }
}
