package Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyPool {

    private static ExecutorService pool;

    public static ExecutorService getPool(){
        if(pool == null){
            System.out.println("create new pool");
            pool = Executors.newFixedThreadPool(4);
        } else {
            System.out.println("old pool");
        }
        return pool;
    }
}
