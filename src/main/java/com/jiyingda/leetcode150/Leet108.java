package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

/**
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/13 10:07
 */
public class Leet108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5};
        TreeNode node = sortedArrayToBST(nums);
        System.out.print(node);

    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (right - left) / 2 + left;
        TreeNode node =  new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }






    public static TreeNode sortedArrayToBST2(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static TreeNode sortedArrayToBST2(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, right);

        return root;
    }
}
