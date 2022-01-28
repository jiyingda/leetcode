package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

import java.util.*;

/**
 *
 * @author jiyingda.
 * @date 2020/8/1.
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet102 {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        List<List<Integer>> list = levelOrder(n1);
        for(List<Integer> r : list){
            for(Integer i : r){
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean f = false;
        while (deque.size() > 0) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
            if (f) {
                Collections.reverse(temp);
                f = false;
            } else {
                f = true;
            }
            list.add(temp);

        }
        return list;
    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }

        List<List<Integer>> reList = new ArrayList<>();
        int size = 0;
        reList.add(new ArrayList<>());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null && queue.isEmpty()){
                return reList;
            }
            if(node == null){
                reList.add(new ArrayList<>());
                size++;
                queue.offer(null);
            } else {
                reList.get(size).add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return reList;

    }
}
