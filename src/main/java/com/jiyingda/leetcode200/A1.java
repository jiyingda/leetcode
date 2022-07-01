/**
 * @(#)A1.java, 2月 25, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode200;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiyingda
 */
public class A1 {


    static class Node {
        int v;
        List<Node> child;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        List<List<Integer>> list = slution(n1);
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }
    }


    public static List<List<Integer>> slution(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> current = new ArrayList<>();
            while (size > 0) {
                Node temp = deque.poll();
                current.add(temp.v);
                for (Node child : temp.child) {
                    deque.offer(child);
                }
                /*if (temp.left != null) {
                    deque.offer(temp.left);
                }
                if (temp.right != null) {
                    deque.offer(temp.right);
                }*/
                size--;
            }
            list.add(current);
        }
        return list;
    }
}