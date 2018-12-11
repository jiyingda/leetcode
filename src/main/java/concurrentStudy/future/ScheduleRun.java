package concurrentStudy.future;

import java.util.concurrent.*;

public class ScheduleRun {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        System.out.println(System.currentTimeMillis());

        ScheduledFuture<String> future = executorService.schedule(()->{
            System.out.println("aaa" + System.currentTimeMillis());
            return "123";
        }, 4L, TimeUnit.SECONDS);


        System.out.println(future.get());

    }


}
