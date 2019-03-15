package concurrent.thread008;

import concurrent.threadPool.ThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

    public static void main(String[] args){
        //Executors.newCachedThreadPool();
        int NCPU = Runtime.getRuntime().availableProcessors();
        System.out.println(NCPU);
        ConcurrentHashMap map = new ConcurrentHashMap();

        HashMap m = new HashMap();
        map.put("a","b");
        m.put("q", "q");
        System.out.println("s");


    }
}
