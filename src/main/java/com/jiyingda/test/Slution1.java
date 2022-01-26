/**
 * @(#)Slution1.java, 1月 11, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.mashape.unirest.http.JsonNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jiyingda
 */
public class Slution1 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        List<List<Integer>> list = slution(n1);
        System.out.print(list);

    }



    public static List<List<Integer>> slution(Node root) {
        Node zero = new Node(0);
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);
        nodeDeque.add(zero);
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int k = 0;
        while (nodeDeque.size() != 0) {
            Node temp = nodeDeque.poll();
            if (zero != temp) {
                list.add(temp.v);
                if (temp.left != null) {
                    nodeDeque.add(temp.left);
                }
                if (temp.right != null) {
                    nodeDeque.add(temp.right);
                }
            } else {
                List<Integer> sortList = new ArrayList<>(list);
                if (k % 2 == 0) {

                }
                k++;
                allList.add(sortList);
                list.clear();
                if (nodeDeque.size() != 0) {
                    nodeDeque.add(zero);
                }
            }
        }

        return allList;
    }

    public static class Node {
        int v;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }
    }
}