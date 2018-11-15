package concurrent.thread;

import java.util.concurrent.TimeUnit;

public class FlageThreadExitTest {

    static class MyTask extends Thread{
        private volatile  boolean closed = false;

        @Override
        public void run(){
            System.out.println("I will start work");
            while (!closed && !isInterrupted()){

            }
            System.out.println("i will be exiting");

        }

        public void close(){
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String... args) throws InterruptedException{
        MyTask t= new MyTask();
        t.start();

        TimeUnit.MICROSECONDS.sleep(5);
        System.out.println("system will be shutdown");
        t.close();
    }

}
