package concurrentStudy.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Service1 {

    private Semaphore semaphore = new Semaphore(1);


    public void testMethid(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + " queue length = " + semaphore.getQueueLength());
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " end time = " + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
