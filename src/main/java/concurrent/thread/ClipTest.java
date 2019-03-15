package concurrent.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClipTest {





    static class BoreManager{
        int boreCount = 1;
        boolean flag = false;
        ArrayBlockingQueue<Integer> blocking = new ArrayBlockingQueue<>(12);
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        public void send(){
            lock.lock();
            try{
                if(!flag){
                    condition1.await();
                }
                if(blocking.size() == 0){
                    flag = false;
                    condition2.signal();
                } else {
                    Integer i = blocking.take();
                    System.out.println("发射第:" + i + "个子弹");
                    blocking.remove(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void loading(){
            lock.lock();
            try{
                if(flag){
                    condition2.await();
                }
                if(blocking.size() == 12){
                    flag = true;
                    condition1.signal();
                } else {
                    blocking.put(boreCount);
                    System.out.println("第:" + boreCount );
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
