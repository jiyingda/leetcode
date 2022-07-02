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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(10);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.print(maxPathSumF(n1));;

    }

    static int mmax = 0;

    public static int maxPathSumF(TreeNode root) {
        maxPathSumFunction(root);
        return mmax;
    }

    public static int maxPathSumFunction(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPathSumFunction(root.left);
        int right = maxPathSumFunction(root.right);
        int a = left + root.val + right;
        int b = root.val;
        int c = left;
        int d = right;
        int e = left + root.val;
        int f = right + root.val;
        mmax = Math.max(Math.max(Math.max(a, b), Math.max(c, d)), Math.max(Math.max(e, f), mmax));
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }





    static int max;

    public static int maxPathSum2(TreeNode root) {
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
