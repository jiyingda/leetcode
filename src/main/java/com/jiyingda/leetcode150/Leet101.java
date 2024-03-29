package com.jiyingda.leetcode150;

import com.jiyingda.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiyingda.
 * @date 2020/7/26.
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet101 {


    public static void main(String[] args){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.right = a5;

        System.out.print(isSymmetric(a1));
    }


    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.value != right.value) {
            return false;
        }
        boolean f1 = isSymmetric(left.left, right.right);
        if (!f1) {
            return false;
        }

        return isSymmetric(left.right, right.left);
    }











    public static boolean isSymmetric2(TreeNode root) {

        class A {
            TreeNode a;
            TreeNode b;

            public A(TreeNode a, TreeNode b) {
                this.a = a;
                this.b = b;
            }

            public TreeNode getA() {
                return a;
            }

            public void setA(TreeNode a) {
                this.a = a;
            }

            public TreeNode getB() {
                return b;
            }

            public void setB(TreeNode b) {
                this.b = b;
            }
        }
        if(root == null){
            return false;
        }
        Queue<A> queue = new LinkedList<>();
        queue.offer(new A(root.left, root.right));
        while (!queue.isEmpty()){
            A a = queue.poll();
            if(a.a == null && a.b==null){
            } else if (a.a != null && a.b!= null && a.a.value == a.b.value){
                queue.offer(new A(a.a.left, a.b.right));
                queue.offer(new A(a.a.right, a.b.left));
            } else {
                return false;
            }
        }
        return true;
    }
}
