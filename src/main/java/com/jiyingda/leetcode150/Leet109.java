package com.jiyingda.leetcode150;

import com.jiyingda.entity.ListNode;
import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/14.
 */
public class Leet109 {

    public static void main(String[] args){
        ListNode head = new ListNode(-10);
        ListNode head1 = new ListNode(-3);
        ListNode head2 = new ListNode(0);
        ListNode head3 = new ListNode(5);
        ListNode head4 = new ListNode(9);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        TreeNode node = sortedListToBST(head);
        System.out.print(node);

    }


    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] nums = list.toArray(new Integer[0]);
        return sortedArrayToBST(nums, 0, nums.length-1);
    }


    public static TreeNode sortedArrayToBST(Integer[] nums, int left, int right) {
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
