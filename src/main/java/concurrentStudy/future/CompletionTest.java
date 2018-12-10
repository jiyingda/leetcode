package concurrentStudy.future;

import java.util.concurrent.*;

public class CompletionTest {


    public static void main(String... args) throws InterruptedException, ExecutionException {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        CompletionService completionService = new ExecutorCompletionService(threadPoolExecutor);

            completionService.submit(()->{
                TimeUnit.SECONDS.sleep(5);
                System.out.println();
                return " time = " + System.currentTimeMillis();
            });


            System.out.println(completionService.take().get());



    }
}
