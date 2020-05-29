package com.jiyingda.tree;

import com.jiyingda.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * 二叉树的层次遍历
 * 通过队列来处理
 * 把头结点入队
 * 出队并把子结点入队
 *
 * @author jiyingda.
 * @date 2020/5/29.
 */
public class TreeLevelTraversal {

    public static void main(String[] args){
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        TreeNode<Integer> n3 = new TreeNode<>(3);
        TreeNode<Integer> n4 = new TreeNode<>(4);
        TreeNode<Integer> n5 = new TreeNode<>(5);
        TreeNode<Integer> n6 = new TreeNode<>(6);
        n4.left = n5;
        n4.right = n6;
        n2.left = n4;
        n1.left = n2;
        n1.right = n3;

        TreeNode<Integer> n0 = new TreeNode<>(0);

        int i = 1;
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(n0);
        queue.offer(n1);
        while (!queue.isEmpty()){
            TreeNode<Integer> tmp = queue.poll();
            if(tmp.value.equals(n0.value)){
                System.out.println("\nlevel = " + i);
                i++;
                if(queue.isEmpty()){
                    break;
                }
                queue.offer(n0);
            } else {
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                System.out.print(tmp.value);
            }

        }

    }
}
