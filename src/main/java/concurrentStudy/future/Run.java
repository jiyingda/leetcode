package concurrentStudy.future;

import java.util.concurrent.*;

public class Run {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        //MyCallable myCallable = new MyCallable(10);


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3, 5L, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        int a = 0;

        Future<String> future = poolExecutor.submit(()->{

            TimeUnit.SECONDS.sleep(5);
            return " time = " + a + System.currentTimeMillis();
        });

        System.out.println(System.currentTimeMillis());
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis());

    }


}
