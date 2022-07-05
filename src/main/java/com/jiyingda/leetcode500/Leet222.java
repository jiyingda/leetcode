package com.jiyingda.leetcode500;

import com.jiyingda.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/25 14:42
 */
public class Leet222 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        //n1.left = n2;
        //n1.right = n3;
        //n2.left = n4;
        //n2.right = n5;
        //n3.left = n6;
        //n3.right = n7;
        System.out.print(countNodes(n1));;

    }

    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
