package concurrent.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                    e.printStackTrace();
                }finally {
                    System.out.println("end");
                }

/*for(;;){
    System.out.println("1");
}*/

        });
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
