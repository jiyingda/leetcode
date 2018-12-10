package concurrentStudy.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {

    private int age;

    public MyCallable(int age){
        super();
        this.age = age;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return "age = " + age + " time = " + System.currentTimeMillis();
    }
}
