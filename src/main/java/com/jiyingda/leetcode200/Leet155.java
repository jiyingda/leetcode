package com.jiyingda.leetcode200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiyingda
 * @date 2020/12/20 19:29
 */
public class Leet155 {
    private Deque<Integer> stack;
    private Integer min;
    public static void main(String[] args) {
        Leet155 obj = new Leet155();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());;
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }

    /** initialize your data structure here. */
    public Leet155() {
        stack = new LinkedList<>();
        min = null;
    }

    public void push(int x) {
        stack.addLast(x);
        if(min == null){
            min = x;
        } else {
            if(x < min){
                min = x;
            }
        }
    }

    public void pop() {
        int last = stack.removeLast();
        if(min == last){
            if(stack.isEmpty()){
                min = null;
            } else {
                min = stack.getFirst();
                for(Integer a : stack){
                    if(a < min){
                        min = a;
                    }
                }
            }
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }
}
