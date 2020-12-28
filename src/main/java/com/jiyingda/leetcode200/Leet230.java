package com.jiyingda.leetcode200;

import com.jiyingda.tree.TreeNode;

/**
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/28.
 */
public class Leet230 {

    private static Integer val = null;

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.print(kthSmallest(n1, 4));;


    }



    public static int kthSmallest(TreeNode root, int k) {
        val = null;
        dooo(root, k, 0);
        return val;
    }

    public static int dooo(TreeNode root, int k, int idx) {
        if(val != null){
            return -1;
        }
        if(root == null){
            return idx;
        }
        int l = dooo(root.left, k, idx);
        if(l + 1 == k){
            val = root.val;
            return -1;
        }
        return dooo(root.right, k, l+1);
    }
}
