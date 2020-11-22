package com.jiyingda.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jiyingda
 * @date 2020/11/22 22:50
 */
public class Tree<T extends Comparable<? super T>> {

    private TreeNode<T> root;

    public Tree() {
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T v){
        if(isEmpty()){
            root = new TreeNode<>(v);
        } else {
            insert(v, root);
        }
    }

    private void insert(T v, TreeNode<T> root){
        if(v.compareTo(root.val) > 0){
            if(root.right == null){
                root.right = new TreeNode<>(v);
            } else {
                insert(v, root.right);
            }
        } else {
            if(root.left == null){
                root.left = new TreeNode<>(v);
            } else {
                insert(v, root.left);
            }
        }
    }

    public void printTreeQueue(){
        if(isEmpty()){
            System.out.print("Empty Tree");
        } else {
            Queue<TreeNode<T>> queue = new ArrayDeque<>();
            queue.offer(root);
            TreeNode<T> zero = new TreeNode<>(null);
            queue.offer(zero);
            while (!queue.isEmpty()){
                TreeNode<T> node = queue.poll();
                if(node == zero){
                    System.out.println();
                    if(!queue.isEmpty()){
                        queue.offer(zero);
                    }
                } else {
                    System.out.print(node.val + "\t");
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }

    }

    public void printTree(){
        if(isEmpty()){
            System.out.print("Empty Tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(TreeNode<T> t){
        if(t != null){
            printTree(t.left);
            System.out.println("" + t.val);
            printTree(t.right);
        }
    }
    private static final int ALLOWED_IMBALANCE = 1;
    private void balance(TreeNode<T> t){
        if(t == null){
            return;
        }
        if(height(t.left)-height(t.right) > ALLOWED_IMBALANCE){
            if(height(t.left.left) >= height(t.left.right)){
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if(height(t.right)-height(t.left) > ALLOWED_IMBALANCE){
            if(height(t.right.right) >= height(t.right.left)){
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;

    }

    private TreeNode<T> rotateWithLeftChild(TreeNode<T> k2){
        TreeNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private TreeNode<T> rotateWithRightChild(TreeNode<T> y){
        TreeNode<T> x = y.left;
        TreeNode<T> t3 = x.right;
        x.right = y;
        y.left = t3;
        y.height = Math.max(height(y.right), height(y.left)) + 1;
        x.height = Math.max(height(x.right), height(x.right)) + 1;
        return x;
    }

    private TreeNode<T> doubleWithLeftChild(TreeNode<T> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private int height(TreeNode<T> t){
        return t == null ? -1 : t.height;
    }

    private static class TreeNode<T>{
        T val;
        TreeNode<T> left;
        TreeNode<T> right;
        int height;

        public TreeNode(T val) {
            this.val = val;
            this.height = 0;
        }
    }

}
