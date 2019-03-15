package jyd.array;

import Utils.MyPool;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ArrayTet2 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int re = 0;
        ExecutorService executorService = MyPool.getPool();
        List<Future> list = new ArrayList<>(16);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i = 0; i < 10; i++){
            Future<Integer> future = executorService.submit(()->{
                int k = 0;
                for(int j = 0; j < 100; j++){
                    k++;
                }
                countDownLatch.countDown();
                return k;
            });
            list.add(future);
        }

        countDownLatch.await();
        for(Future f : list){
            re = (Integer) f.get() + re;
        }
        System.out.println(re);


    }
}
