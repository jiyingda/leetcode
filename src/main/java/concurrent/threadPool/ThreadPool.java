package concurrent.threadPool;

public interface ThreadPool {

    /**
     * 提交任务到线程池
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池的初始大小
     * @return
     */
    int getInitSize();

    /**
     * 获取线程池最大的线程数
     * @return
     */
    int getMaxSize();

    /**
     * 获取线程池的核心线程的数量
     * @return
     */
    int getCoreSize();

    /**
     * 获取线程池中活跃线程的数量
     * @return
     */
    int getActiveCount();

    int getQueueSize();

    /**
     * 查看是否关闭
     * @return
     */
    boolean isShutdown();

}
