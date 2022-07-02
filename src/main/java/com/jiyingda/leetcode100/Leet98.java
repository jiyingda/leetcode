package com.jiyingda.leetcode100;


/**
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/12 22:13
 */
public class Leet98 {
    public static void main(String[] args) {
        System.out.print(Integer.MAX_VALUE == 2147483647);
        TreeNode t1 = new TreeNode(2147483647);
        TreeNode t2 = new TreeNode(2147483647);
        t1.left = t2;

        System.out.print(isValidBST(t1));;

    }


    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val <= root.left.val || root.left.val <= left) {
                return false;
            }
            if (!isValidBST(root.left, left, root.val)) {
                return false;
            }

        }
        if (root.right != null) {
            if (root.val >= root.right.val || root.right.val >= right) {
                return false;
            }
            if (!isValidBST(root.right, root.val, right)) {
                return false;
            }

        }
        return true;
    }




    /*public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static boolean isValidBST(TreeNode root, long left, long right) {
        if(root == null){
            return true;
        }
        if(root.val <= left  || root.val >= right ){
            return false;
        }
        if(root.left != null){
            if(!isValidBST(root.left, left, root.val)){
                return false;
            }
        }
        if(root.right != null){
            if(!isValidBST(root.right, root.val, right)){
                return false;
            }
        }
        return true;
    }*/

    public static class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
