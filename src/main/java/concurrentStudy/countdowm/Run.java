package concurrentStudy.countdowm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Run {



    public static void main(String... args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("all is come");
            }
        });

        Thread[] tList = new Thread[5];
        for(int i = 0; i < 5; i++){
            tList[i] = new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " is done");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }


        for (Thread thread : tList) {
            thread.start();
        }

    }
}
