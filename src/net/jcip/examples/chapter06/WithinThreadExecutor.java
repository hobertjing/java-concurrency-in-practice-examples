package net.jcip.examples.chapter06;

import java.util.concurrent.*;

/**
 * WithinThreadExecutor
 * <p/>
 * Executor that executes tasks synchronously in the calling thread
 * 在调用线程中已同步方式执行所有任务的Executor
 */
public class WithinThreadExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    };
}
