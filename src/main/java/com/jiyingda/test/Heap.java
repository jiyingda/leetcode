package com.jiyingda.test;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiyingda
 * @date 2020/11/16 23:12
 */
public class Heap {

    public static void init(int[] arr){
        int len = arr.length;
        for(int j = 0; j < len/2; j=j*2+1){
            for(int i = len/2-1; i >=j; i--){
                if(i * 2 + 2 < len && arr[i * 2+1] > arr[i * 2 + 2]){
                    int t = arr[i*2+1];
                    arr[i*2+1] = arr[i*2 +2];
                    arr[i*2 + 2] = t;
                }
                if(arr[i] > arr[i*2+1]){
                    int t = arr[i];
                    arr[i] = arr[i*2+1];
                    arr[i*2+1] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{7,2,4,5,1,6,3,9,8};
        init(arr);

        for(int i : arr){
            System.out.print(i);
        }



        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(11);
        queue.add(2);
        queue.add(13);
        queue.add(6);
        System.out.println(queue.size());

        Date now = new Date();
        System.out.println("\n" + now.getTime());
        long st = now.getTime() - 2 * 24 * 60 * 60 * 1000;
        System.out.println("\n" + st);



    }

    public static void tttt2(){
        new Thread(()->{
            synchronized (Heap.class){
                System.out.println("t2\t" + System.currentTimeMillis());
                try {
                    Heap.class.notify();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2\t" + System.currentTimeMillis());

            }
        },"222").start();
    }

    public static void tttt(){

        new Thread(()->{
            synchronized (Heap.class){
                System.out.println("t1\t"+ System.currentTimeMillis());
                try {
                    Heap.class.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1\t"+ System.currentTimeMillis());

            }
        }, "111").start();

        lock.unlock();
    }

    static Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();


}
