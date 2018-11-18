package concurrent.thread006;

import java.util.concurrent.TimeUnit;

public class VloatileFoo {

    final static int MAX = 5;

    static volatile int init_value = 0;

    public static void main(String[] arg){
        new Thread(()->{
           int localValue = init_value;
           while (localValue < MAX){
               if(init_value != localValue){
                   System.out.printf("init value is updated to [%d]\n",init_value);
                   localValue = init_value;
               }
           }
        },"Reader").start();

        new Thread(()->{
            int localValue = init_value;
            while (localValue < MAX){
                System.out.printf("init_value will be change to [%d]\n",++localValue);
                init_value = localValue;
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"updater").start();

        String s = "";



    }

}
