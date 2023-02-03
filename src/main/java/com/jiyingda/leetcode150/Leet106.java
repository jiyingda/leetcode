package com.jiyingda.leetcode150;

import com.jiyingda.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda.
 * @date 2020/12/14.
 */
public class Leet106 {

    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.print(root);
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, postorder.length-1, 0, postorder.length-1,map);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder,int left, int right,int p_left,int p_right, Map<Integer, Integer> map) {
        if(left > right){
            return null;
        }
        if(p_right < 0){
            return null;
        }
        if(p_left >= postorder.length){
            return null;
        }
        int rootVal = postorder[p_right];
        TreeNode rootNode = new TreeNode(rootVal);
        int idx = map.get(rootVal);


        rootNode.left = buildTree(inorder, postorder, left, idx-1,p_left, p_left + idx - left-1, map);
        rootNode.right = buildTree(inorder, postorder, idx+1, right,p_left + idx - left, p_right-1, map);
        return rootNode;
    }

}
