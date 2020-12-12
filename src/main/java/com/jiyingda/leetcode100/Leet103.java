package com.jiyingda.leetcode100;


import com.jiyingda.tree.TreeNode;

import java.util.*;

/**
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/12 23:01
 */
public class Leet103 {
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
        List<List<Integer>> list = zigzagLevelOrder(t3);
        for(List<Integer> ls : list){
            for(Integer i : ls){
                System.out.print(i + " , ");
            }
            System.out.print("\n");
        }

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> tmpList = new ArrayList<>();
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(left);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp == right){
                Collections.reverse(tmpList);
                list.add(new ArrayList<>(tmpList));
                tmpList.clear();
                if(!queue.isEmpty()){
                    queue.offer(left);
                }

            } else if(temp == left){
                list.add(new ArrayList<>(tmpList));
                tmpList.clear();
                if(!queue.isEmpty()){
                    queue.offer(right);
                }
            } else {
                tmpList.add(temp.val);
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return list;
    }
}
