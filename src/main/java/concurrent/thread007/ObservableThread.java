package concurrent.thread007;

import java.util.concurrent.TimeUnit;

public class ObservableThread<T> extends Thread implements Observable{

    private final TaskLifecycle<T> lifecycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(Task<T> tTask){

        this(new TaskLifecycle.EmptyLifecycle<>(),tTask);
    }

    public ObservableThread(TaskLifecycle<T> lifecycle, Task<T> tTask){
        super();
        if(tTask == null){
            throw new IllegalArgumentException("thr task is required");
        }
        this.lifecycle = lifecycle;
        this.task = tTask;

    }

    @Override
    public final void run(){
        this.update(Cycle.STARTED, null, null);
        try{
            this.update(Cycle.RUNNING, null, null);

            T result = this.task.call();
            this.update(Cycle.DONE,result,null);
        }catch (Exception e){
            this.update(Cycle.ERROR, null, e);
        }
    }


    private void update(Cycle cycle, T result, Exception e){
        this.cycle = cycle;
        if(lifecycle == null){
            return;
        }
        try{
            switch (cycle){
                case STARTED:
                    this.lifecycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.lifecycle.onError(currentThread(), e);
                    break;
            }
        }catch (Exception ex){
            if(cycle == Cycle.ERROR){
                throw  ex;
            }
        }
    }


    @Override
    public Cycle getCycle() {
        return null;
    }

    public static void main(String[] args){
        final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>(){
            public void onFinish(Thread thread, String result){
                System.out.println("the result is" + result);
            }

        };

        Observable observableThread = new ObservableThread<>(lifecycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("finish done");
            return "hello observer";

        });

        observableThread.start();

    }
}
