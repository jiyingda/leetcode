package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/15.
 */
public class Leet113 {

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
        TreeNode n10 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        n6.left = n10;

        List<List<Integer>> list = pathSum(n1, 22);
        for(List<Integer> ls : list){
            for(Integer i : ls){
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }

    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        pathSum(root, sum, list, new ArrayList<>());
        return list;
    }

    public static void pathSum(TreeNode root, int sum, List<List<Integer>> list, List<Integer> current) {
        if(root == null){
            return;
        }
        current.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                list.add(new ArrayList<>(current));
            }
            return;
        }
        if(root.left != null){
            pathSum(root.left, sum-root.val, list, current);
            current.remove(current.size()-1);
        }
        if(root.right != null){
            pathSum(root.right, sum-root.val, list, current);
            current.remove(current.size()-1);
        }
    }
}
