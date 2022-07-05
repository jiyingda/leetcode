/**
 * @(#)MyHashSet.java, 2月 23, 2022.
 * <p>
 * Copyright 2022 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode;

/**
 * @author jiyingdabj
 */
public class MyHashSet {

    private int capacity;
    private int[] table;
    private int size;

    public MyHashSet() {
        capacity = 16;
        size = 0;
        table = new int[capacity];
    }

    public void add(int key) {
        int idx = key % capacity;
    }

    public void remove(int key) {

    }

    public boolean contains(int key) {

        return false;
    }


}
