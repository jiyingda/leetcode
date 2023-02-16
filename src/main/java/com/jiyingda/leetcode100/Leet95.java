/**
 * @(#)Leet95.java, 6月 22, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode100;

import com.jiyingda.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet95 {

    public static void main(String[] args) {
        Leet95 leet95 = new Leet95();
        List<TreeNode> list = leet95.generateTrees(3);
        System.out.println(list);
    }




    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }


    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
            return list;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = generateTrees(left, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, right);
            for (TreeNode l : leftList) {
                for (TreeNode r : rightList) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = l;
                    currTree.right = r;
                    list.add(currTree);
                }
            }
        }
        return list;
    }
}
