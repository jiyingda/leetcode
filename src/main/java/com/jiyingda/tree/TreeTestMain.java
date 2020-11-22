package com.jiyingda.tree;

/**
 * @author jiyingda
 * @date 2020/11/22 22:57
 */
public class TreeTestMain {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.printTree();
        System.out.print("-------------\n");
        tree.printTreeQueue();


    }
}
