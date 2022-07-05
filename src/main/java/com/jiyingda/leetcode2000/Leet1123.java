/**
 * @(#)Leet1123.java, 3月 23, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import com.jiyingda.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Leet1123 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n5.right = n7;
        n3.left = n8;
        n3.right = n9;
        TreeNode node = lcaDeepestLeaves(n1);
        System.out.println(node);

    }


    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0, new ArrayList<>());
        int i = list.get(0).size() - 1;
        for (; i >= 0; i--) {
            boolean f = true;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(0).get(i) != list.get(j).get(i)) {
                    f = false;
                    break;
                }
            }
            if (f) {
                return list.get(0).get(i);
            }

        }
        return root;
    }
    static int max = 0;
    static List<List<TreeNode>> list = new ArrayList<>();

    public static void dfs(TreeNode root, int len, List<TreeNode> current) {
        current.add(root);
        if (root.left != null) {
            dfs(root.left, len + 1, current);
        }
        if (root.right != null) {
            dfs(root.right, len + 1, current);
        }
        if (root.left == null && root.right == null) {
            if (len > max) {
                max = len;
                list.clear();
                list.add(new ArrayList<>(current));
            } else if (len == max) {
                list.add(new ArrayList<>(current));
            }
        }
        current.remove(current.size() - 1);

    }
}
