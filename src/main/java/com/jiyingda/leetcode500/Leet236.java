/**
 * @(#)Leet236.java, 2月 08, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

import com.jiyingda.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Leet236 {
    List<TreeNode> pList = new ArrayList<>();
    List<TreeNode> qList = new ArrayList<>();
    boolean pf = true;
    boolean qf = true;

    public static void main(String[] args) {
        Leet236 leet236 = new Leet236();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        TreeNode nnn = leet236.lowestCommonAncestor(n1, n4, n2);
        System.out.println("");
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pList = new ArrayList<>();
        this.qList = new ArrayList<>();
        this.pf = true;
        this.qf = true;
        dfs(root, p, q);
        int i = 0;
        while (i < pList.size() && i < qList.size() && pList.get(i) == qList.get(i)) {
            i++;
        }

        return pList.get(i - 1);
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if (!pf && !qf) {
            return;
        }
        if (pf) {
            pList.add(root);
            if (root == p) {
                pf = false;
                if (!qf) {
                    return;
                }
            }
        }

        if (qf) {
            qList.add(root);
            if (root == q) {
                qf = false;
                if (!pf) {
                    return;
                }
            }
        }
        dfs(root.left, p, q);
        dfs(root.right, p, q);
        if (pf) {
            pList.remove(pList.size() - 1);
        }
        if (qf) {
            qList.remove(qList.size() - 1);
        }
    }
}
