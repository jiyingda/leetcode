/**
 * @(#)Solution011903.java, 1月 19, 2025.
 * <p>
 * Copyright 2025 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.redo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiyingda
 */
public class Solution011903 {
    public static void main(String[] args) {

    }

    public Node copyRandomListV2(Node head) {
        if (head == null){
            return null;
        }
        Map<Node, Node> old2NewMap = new HashMap<>();
        return copyRandomListInner(head, old2NewMap);
    }

    public Node copyRandomListInner(Node head, Map<Node, Node> old2NewMap) {
        if (head == null) {
            return head;
        }
        if (!old2NewMap.containsKey(head)) {
            Node newNode = new Node(head.val);
            old2NewMap.put(head, newNode);
            newNode.next = copyRandomListInner(head.next, old2NewMap);
            newNode.random = copyRandomListInner(head.random, old2NewMap);
        }
        return old2NewMap.get(head);

    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node newHead = new Node(0);
        Node reNewHead = newHead;
        Map<Node, Node> old2NewMap = new HashMap<>();
        while (head != null) {
            Node node;
            if(old2NewMap.containsKey(head)){
                node = old2NewMap.get(head);
            } else {
                node = new Node(head.val);
                old2NewMap.put(head, node);
            }
            Node random = null;
            if (head.random != null) {
                if (old2NewMap.containsKey(head.random)) {
                    random = old2NewMap.get(head.random);
                } else {
                    random = new Node(head.random.val);
                    old2NewMap.put(head.random, random);
                }
            }
            node.random = random;
            newHead.next = node;
            newHead = newHead.next;
            head = head.next;
        }

        return reNewHead.next;

    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}