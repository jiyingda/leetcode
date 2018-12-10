package concurrentStudy.countdowm;

import java.util.concurrent.*;

public class ExerctureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });


        //executorService.shutdownNow();
        System.out.println(executorService.isShutdown());


        Future<String> future = executorService.submit(()->{
            TimeUnit.SECONDS.sleep(5);
            return " time = " + System.currentTimeMillis();
        });

        System.out.println(System.currentTimeMillis());
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis());


    }


}
