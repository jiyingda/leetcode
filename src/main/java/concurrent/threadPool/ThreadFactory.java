package concurrent.threadPool;

@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runable);
}
