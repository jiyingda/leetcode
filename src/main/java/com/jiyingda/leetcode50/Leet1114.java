package com.jiyingda.leetcode50;

/**
 * @author jiyingda
 * @date 2019/8/15
 */
public class Leet1114 {

    volatile int a = 0;

    public void first(Runnable printFirst) throws InterruptedException {

        while (a == 0){
            System.out.println("one");
            a = 1;

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (a == 1){
            System.out.println("one");
            a = 2;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (a == 2){
            System.out.println("one");
            a = 3;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
