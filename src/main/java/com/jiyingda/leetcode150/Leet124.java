package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyin
 * @date 2020/8/1 14:10
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet124 {

    public static void main(String[] args){
        //[5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n4.right = n5;

        System.out.print(maxPathSum(n1));;

    }

    static int max;

    public static int maxPathSum(TreeNode root) {
        max = root.val;
        int mm = maxSum(root);
        return Math.max(max, mm);
    }

    public static int maxSum(TreeNode root) {

        int m = root.val;
        int mm = m;
        int l = 0;
        int r = 0;
        if(root.left != null){
            l = maxSum(root.left);
            mm = Math.max(mm, m + l);
            max= Math.max(max, l);
        }
        if(root.right != null){
            r = maxSum(root.right);
            mm = Math.max(mm, m + r);
            max = Math.max(max, r);
        }
        if(root.left != null && root.right != null){
            max= Math.max(max, m + l + r);
        }

        return mm;
    }

}
