/**
 * @(#)Leet671.java, 9月 15, 2022.
 */
package com.jiyingda.leetcode1000;

import java.util.Collections;
import java.util.List;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * <p>
 * 如果第二小的值不存在的话，输出 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingdabj
 */
public class Leet671 {

    private static int min = 0;

    public static void main(String[] args) {
        List<Integer> a = Collections.emptyList();
        a.stream().forEach(e -> e = 1);
    }

    public int findSecondMinimumValue(TreeNode root) {
        min = Integer.MAX_VALUE;
        dfs(root);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(TreeNode root) {
        if (root.left == null || root.right == null) {
            return;
        }
        if (root.left.val == root.val) {
            min = Math.min(min, root.right.val);
            dfs(root.left);
        }
        if (root.right.val == root.val) {
            min = Math.min(min, root.left.val);
            dfs(root.right);
        }
    }
}
