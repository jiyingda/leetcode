package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedPool {

    public static void main(String... args){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;

            cachedThreadPool.execute(()->{
            System.out.println(Thread.currentThread().getName() + "=" + index);
            });
        }

    }
}
