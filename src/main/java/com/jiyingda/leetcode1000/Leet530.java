/**
 * @(#)Leet530.java, 3月 22, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode1000;

/**
 * @author jiyingdabj
 */
public class Leet530 {

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        if (root.left != null) {
            int l = dfs(root.left, true);
            min = Math.min(min, Math.abs(l - root.val));
        }
        if (root.right != null) {
            int r = dfs(root.right, false);
            min = Math.min(min, Math.abs(r - root.val));
        }


        return min;
    }

    private int min = Integer.MAX_VALUE;

    public int dfs(TreeNode root, boolean isLeft) {
        int a = root.val;
        int b = root.val;
        int c = root.val;
        if (root.left != null) {
            int l = dfs(root.left, true);
            min = Math.min(min, Math.abs(l - root.val));
            a = l;
        }
        if (root.right != null) {
            int r = dfs(root.right, false);
            min = Math.min(min, Math.abs(r - root.val));
            b = r;
        }
        return isLeft ? root.val : Math.min(c, Math.min(a, b));
    }
}
