package concurrent.thread003;

import java.util.concurrent.TimeUnit;

public class UncaughtTest {


    public static void main(String[] args){
        /*Thread.setDefaultUncaughtExceptionHandler((t, e)->{
            System.out.println(t.getName());
            e.printStackTrace();
        });*/

        ThreadGroup maingroup = Thread.currentThread().getThreadGroup();
        System.out.println(maingroup.getName());
        System.out.println(maingroup.getParent());
        System.out.println(maingroup.getParent().getParent());



        final Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1 / 0);
        }, "test-thread");

        thread.start();
    }
}
