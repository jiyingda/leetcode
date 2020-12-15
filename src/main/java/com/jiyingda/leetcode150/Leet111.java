package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/14.
 */
public class Leet111 {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        n5.right = n8;
        System.out.print(minDepth(n1));;

    }



    public static int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null){
            return minDepth;
        }
        TreeNode zero = new TreeNode(0);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(zero);
        minDepth++;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(zero == node){
                minDepth++;
                if(!queue.isEmpty()){
                    queue.offer(zero);
                }
            } else if(node.left == null && node.right == null){
                break;
            } else {
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }


        }

        return minDepth;
    }
}
