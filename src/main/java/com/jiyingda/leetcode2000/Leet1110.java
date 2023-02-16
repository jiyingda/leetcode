/**
 * @(#)Leet1110.java, 3月 24, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class Leet1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> list = new ArrayList<>();
        dfs(root, set, list);
        return list;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> list) {
        if (root == null) {
            return null;
        }
        TreeNode l = dfs(root.left, set, list);
        TreeNode r = dfs(root.right, set, list);
        if (set.contains(root.value)) {
            if (l != null) {
                list.add(l);
            }
            if (r != null) {
                list.add(r);
            }
            return null;
        }
        root.left = l;
        root.right = r;
        return root;
    }
}
