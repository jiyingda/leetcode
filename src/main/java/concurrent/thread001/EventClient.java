package concurrent.thread001;

import java.util.concurrent.TimeUnit;

public class EventClient {


    public static void main(String[] args){
        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            for(int j = 0;j <20;j++){
                eventQueue.offer(new EventQueue.Event());

            }
        }, "producer_1").start();

        new Thread(() -> {
            for(int i = 0; i < 20; i ++){
                eventQueue.offer(new EventQueue.Event());

            }
        }, "producer_2").start();


        new Thread(() -> {
            for(int k =0; k < 50;k++){
                eventQueue.take();
                System.out.println(k);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"consumer").start();
    }
}
