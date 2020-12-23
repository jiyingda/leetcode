package com.jiyingda.leetcode200;

import com.jiyingda.tree.TreeNode;

import java.util.*;

/**
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/23 19:24
 */
public class Leet199 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n2.right = n5;
        n1.right = n3;
        n3.right = n4;
        List<Integer> list = rightSideView(n1);
        for(Integer i : list){
            System.out.print(i + " -> ");
        }

    }


    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode zero = new TreeNode(0);
        queue.offer(zero);
        list.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == zero){
                if(!queue.isEmpty()){
                    TreeNode tmp = queue.peek();
                    list.add(tmp.val);
                    queue.offer(zero);
                }
            } else {
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return list;
    }
}
