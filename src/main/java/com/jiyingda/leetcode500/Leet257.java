package com.jiyingda.leetcode500;

import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/30.
 */
public class Leet257 {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append("->");
        int a = sb.length();
        sb.append("->");
        sb.delete(a, sb.length());
        System.out.print(sb.toString() + "\n");
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n2.left = n5;
        List<String> list = binaryTreePaths(n1);
        System.out.print(list);

    }



    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
            return list;
        }
        int a = sb.length();
        if(root.left != null){
            binaryTreePaths(root.left, sb, list);
            sb.delete(a, sb.length());
        }
        if(root.right != null){
            binaryTreePaths(root.right, sb, list);
        }
        return list;
    }

    public static void binaryTreePaths(TreeNode root, StringBuilder sb, List<String> list) {
        int a = sb.length();
        sb.append("->").append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
            sb.delete(a, sb.length());
            return;
        }
        if(root.left != null){
            binaryTreePaths(root.left, sb, list);
        }
        if(root.right != null){
            binaryTreePaths(root.right, sb, list);
        }
        sb.delete(a, sb.length());
    }
}
