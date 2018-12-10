package concurrentStudy.semaphore;

import java.util.concurrent.locks.ReentrantLock;

public class Run {

    private ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args){
        Service1 service1 = new Service1();
        Thread thread = new Thread(() -> {
            service1.testMethid();
        });
        Thread thread2 = new Thread(() -> {
            service1.testMethid();
        });

        Thread thread3 = new Thread(() -> {
            service1.testMethid();
        });
        thread.start();
        thread2.start();
        thread3.start();
    }
}
