package concurrentStudy.future;

import java.util.concurrent.ForkJoinPool;

public class RecursiveRun {

    public static void main(String... args){
        ForkJoinPool pool = new ForkJoinPool();

        pool.submit(()->{
            System.out.println("ssssss");
        });
    }
}
