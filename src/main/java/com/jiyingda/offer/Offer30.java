/**
 * @(#)Offer30.java, 1月 28, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author jiyingda
 */
public class Offer30 {

    private PriorityQueue<Integer> q;
    private Stack<Integer> s;

    /** initialize your data structure here. */
    public Offer30() {
        q = new PriorityQueue<>();
        s = new Stack<>();

    }

    public void push(int x) {
        s.push(x);
        q.add(x);

    }

    public void pop() {
        int v = s.pop();
        q.remove(v);
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return q.peek();
    }

    public static void main(String[] args) {

        Offer30 minStack = new Offer30();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());   //  --> 返回 0.
        System.out.println(minStack.min());
        System.out.println(minStack.min());//--> 返回 -2.


    }
}