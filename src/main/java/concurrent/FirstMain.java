package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstMain {
    public static void main(String... args){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;

            fixedThreadPool.execute(()->{System.out.println(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
