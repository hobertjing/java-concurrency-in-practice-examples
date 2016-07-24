package net.jcip.examples.chapter07;

import java.util.concurrent.*;
import static net.jcip.examples.common.LaunderThrowable.launderThrowable;

/**
 * TimedRun
 * <p/>
 * Cancelling a task using Future
 * 通过future来取消任务
 */
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun(Runnable r,
                                long timeout, TimeUnit unit)
            throws InterruptedException {
        Future<?> task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            // task will be cancelled below
        } catch (ExecutionException e) {
            // exception thrown in task; rethrow
            throw launderThrowable(e.getCause());
        } finally {
            // Harmless if task already completed
            task.cancel(true); // interrupt if running
        }
    }
}
