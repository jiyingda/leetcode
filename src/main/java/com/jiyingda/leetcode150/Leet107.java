package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

import java.util.*;

/**
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/12 23:57
 */
public class Leet107 {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t20 = new TreeNode(20);
        TreeNode t9 = new TreeNode(9);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7= new TreeNode(7);
        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        List<List<Integer>> list = levelOrderBottom(t3);
        for(List<Integer> ls : list){
            for(Integer i : ls){
                System.out.print(i + " , ");
            }
            System.out.print("\n");
        }

    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode zero = new TreeNode(0);
        queue.offer(root);
        queue.offer(zero);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp == zero){
                list.add(new ArrayList<>(tempList));
                tempList.clear();
                if(!queue.isEmpty()){
                    queue.offer(zero);
                }
            } else {
                tempList.add(tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
}
