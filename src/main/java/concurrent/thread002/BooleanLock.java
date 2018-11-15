package concurrent.thread002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;


public class BooleanLock implements Lock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();


    @Override
    public void lock() throws InterruptedException{
        synchronized (this){
            while (locked) {
                if (!blockedList.contains(currentThread)){
                    blockedList.add(currentThread);
                }
                this.wait();
            }

            blockedList.remove(currentThread);
            this.locked = true;
            this.currentThread = Thread.currentThread();
        }

    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            if(mills <= 0){
                this.lock();
            } else {
               long remainingMills = mills;
               long endMills = System.currentTimeMillis() + remainingMills;

               while (locked){
                   if (remainingMills <= 0){
                       throw new TimeoutException("canot get the lock during" + mills + " ms");
                   }
                   if(!blockedList.contains(currentThread)){
                       blockedList.add(currentThread);
                   }
                   this.wait(remainingMills);
                   remainingMills = endMills - System.currentTimeMillis();
               }

               blockedList.remove(currentThread);
               this.locked = true;
               this.currentThread = Thread.currentThread();
            }
        }

    }

    @Override
    public void unlock() {

        synchronized (this){
            if(currentThread == Thread.currentThread()){
                this.locked = false;
                Optional.of(Thread.currentThread().getName() + " release the lock").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThread() {
        return Collections.unmodifiableList(blockedList);
    }


}
