package com.jiyingda.entity;

/**
 * 二叉树结构
 *
 * @author jiyingda.
 * @date 2020/5/28.
 */
public class TreeNode<T> {

    public T value;

    public TreeNode<T> left;

    public TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }
}
