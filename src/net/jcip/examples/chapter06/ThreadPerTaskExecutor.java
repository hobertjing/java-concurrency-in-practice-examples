package net.jcip.examples.chapter06;

import java.util.concurrent.*;

/**
 * ThreadPerTaskExecutor
 * <p/>
 * Executor that starts a new thread for each task
 * 为每个请求启动一个新线程的Executor
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    };
}
