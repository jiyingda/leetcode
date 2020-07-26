package com.jiyingda.leetcode100;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jiyingda.
 * @date 2020/7/25.
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet100 {

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3, null, a1);

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(3);
        TreeNode b3 = new TreeNode(3, null, b1);
        System.out.print(isSameTree(a3, b3));

    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p != null && q != null) {

        } else {
            return false;
        }

        Queue<TreeNode> queueA = new ArrayDeque<>();
        Queue<TreeNode> queueB = new ArrayDeque<>();
        TreeNode zero = new TreeNode(Integer.MIN_VALUE);
        queueA.add(p);
        queueB.add(q);

        while (!queueA.isEmpty()){
            if(queueA.size() != queueB.size()){
                return false;
            }
            TreeNode a = queueA.poll();
            TreeNode b = queueB.poll();
            if(a != null && b != null){
                if(a == zero && b== zero){

                } else if(a.val == b.val){
                    add(queueA, a, zero);
                    add(queueB, b, zero);
                } else {
                    return false;
                }
            } else if(a == null && b == null){
                break;

            } else {
                return false;
            }

        }

        return true;
    }

    private static void add(Queue<TreeNode> queue, TreeNode a , TreeNode zero){
        if(a.left == null){
            queue.add(zero);
        } else {
            queue.add(a.left);
        }
        if(a.right == null){
            queue.add(zero);
        }else {
            queue.add(a.right);
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}


