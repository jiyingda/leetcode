package concurrent.threadPool;

public interface RunnableQueue {
    /**
     * 新的任务offer到队列中
     * @param runnable
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过task获取Runnable
     * @return
     */
    Runnable task() throws InterruptedException;

    /**
     * 获取任务队列中任务的数量
     * @return
     */
    int size();
}
