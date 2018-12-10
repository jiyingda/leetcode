package concurrentStudy.countdowm;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(2);
        Thread thread = new Thread(()->{

            System.out.println("a start");
            phaser.arriveAndAwaitAdvance();
            System.out.println("a end");

            System.out.println("a2 start");
            phaser.arriveAndAwaitAdvance();
            System.out.println("a2 end");

        });

        Thread thread2 = new Thread(()->{

            System.out.println("b start");
            phaser.arriveAndAwaitAdvance();
            System.out.println("b end");

            System.out.println("b2 start");
            phaser.arriveAndAwaitAdvance();
            System.out.println("b2 end");

        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread2.start();




    }


}
