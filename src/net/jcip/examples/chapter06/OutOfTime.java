package net.jcip.examples.chapter06;

import java.util.*;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * OutOfTime
 * <p/>
 * Class illustrating confusing Timer behavior
 * 错误的Timer行为
 * Timer 线程并不捕获异常，因此当 TimerTask 抛出未检查的异常时将终止定时线程。
 * 它也不会恢复线程的执行，而是会错误地认为整个 Timer 都被取消了。因此，已经被调度但尚未执行的 TimerTask 将不会在执行，新的任务也不能被调度。
 */

public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }
}
