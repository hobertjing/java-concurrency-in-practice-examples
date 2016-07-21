package net.jcip.examples.chapter07;

import java.util.concurrent.*;

/**
 * NoncancelableTask
 * <p/>
 * Noncancelable task that restores interruption before exit
 * 不可取消的任务在退出前恢复中断
 */
public class NoncancelableTask {
    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    // fall through and retry
                }
            }
        } finally {
            if (interrupted)
                Thread.currentThread().interrupt();
        }
    }

    interface Task {
    }
}
