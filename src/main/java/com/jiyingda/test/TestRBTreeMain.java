package com.jiyingda.test;

import com.jiyingda.entity.RBTree;

/**
 * @author jiyingda.
 * @date 2019/12/10.
 */
public class TestRBTreeMain {


    public static void main(String[] args){
        RBTree<Integer> root = new RBTree<>();
        root.addNode(1);
        root.addNode(2);
        root.addNode(3);
        root.addNode(4);
        root.addNode(5);
        root.addNode(6);



        System.out.println("");
    }
}
