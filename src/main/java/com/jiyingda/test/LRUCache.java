/**
 * @(#)LRUCache.java, 2月 07, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.entity.ListNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);

    }

    private final Node first;
    private final Node last;
    private Map<Integer, Node> map;
    private final int capacity;
    private int currentCapacity;

    public LRUCache(int capacity) {
        this.first = new Node(-1, -1);
        this.last = new Node(-2, -2);
        this.first.next = this.last;
        this.last.pre = this.first;
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public int get(int key) {
        if (currentCapacity < 1) {
            return -1;
        }
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        //Node newNode = node;
        remove(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        } else {
            checkCapacity();
            currentCapacity++;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addFirst(newNode);
    }

    private void checkCapacity() {
        if (currentCapacity >= capacity) {
            removeLast();
        }
    }

    private void removeLast() {
        map.remove(last.pre.key);
        last.pre = last.pre.pre;
        last.pre.next = last;
        currentCapacity--;
    }

    private void remove(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addFirst(Node node) {
        node.next = first.next;
        first.next.pre = node;
        node.pre = first;
        first.next = node;
    }

    public static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
