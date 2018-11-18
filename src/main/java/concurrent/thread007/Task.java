package concurrent.thread007;

@FunctionalInterface
public interface Task<T> {
    T call();
}
