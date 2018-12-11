package concurrentStudy.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String> {

    private int beginValue;

    private int endValue;

    public MyRecursiveTask(int b, int e){
        this.beginValue = b;
        this.endValue = e;
    }


    @Override
    protected String compute() {
        System.out.println(Thread.currentThread().getName() + "----");

        if(endValue - beginValue > 2){
            int middleValue = (endValue + beginValue) / 2;

            MyRecursiveTask leftTask = new MyRecursiveTask(beginValue, middleValue);
            MyRecursiveTask rightTask = new MyRecursiveTask(middleValue + 1, endValue);

            this.invokeAll(leftTask, rightTask);
            return leftTask.join() + rightTask.join();

        } else {

            String re = "";
            for(int i = beginValue; i <= endValue; i++){
                re = re + (i);

            }
            System.out.println("re = " + re + ";" + beginValue + ":" + endValue);
            return re;
        }

    }


    public static void main(String... args){

        ForkJoinPool pool = new ForkJoinPool();

        MyRecursiveTask task = new MyRecursiveTask(1, 20);
        ForkJoinTask<String> re = pool.submit(task);
        System.out.println(re.join());

    }
}
