package net.jcip.examples.chapter07;

import java.util.concurrent.*;

/**
 * InterruptBorrowedThread
 * <p/>
 * Scheduling an interrupt on a borrowed thread
 * 在外部线程中安排中断
 * not recommend
 */
public class TimedRun1 {
	private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

	public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(new Runnable() {
			public void run() {
				taskThread.interrupt();
			}
		}, timeout, unit);
		r.run();
	}
}
