/**
 * @(#)Solution080401.java, 8月 04, 2024.
 * <p>
 * Copyright 2024 . All rights reserved.
 * 
 */
package com.jiyingda.redo;


import com.jiyingda.tree.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * @author jiyingdabj
 */
public class Solution080401 {

    public static void main(String[] args) {
        Solution080401 solution080401 = new Solution080401();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        String s = solution080401.serialize(n1);
        System.out.println(s);
        TreeNode r = solution080401.deserialize(s);
        System.out.println(r);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SP);
            return;
        }
        sb.append(root.val).append(SP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    private static final String SP = ",";
    private static final String NULL = "N";

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        return deserialize(data.split(SP));
    }

    int idx = 0;
    public TreeNode deserialize(String[] data) {
        if (data.length == 0) {
            return null;
        }
        String v = data[idx];
        idx++;
        if (NULL.equals(v)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(v));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}