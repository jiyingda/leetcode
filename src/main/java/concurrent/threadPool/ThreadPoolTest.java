package concurrent.threadPool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String... args) throws InterruptedException {

        final ThreadPool threadPool = new BasicThreadPool(2,6,4,1000);
        for(int i = 0; i < 20; i++){
            threadPool.execute(()->{
                try{
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "is running and done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        for(;;){
            System.out.println(threadPool.getActiveCount());
            System.out.println(threadPool.getQueueSize());
            System.out.println(threadPool.getCoreSize());
            System.out.println(threadPool.getMaxSize());
            System.out.println("====================");
            TimeUnit.SECONDS.sleep(5);
        }

    }
}
