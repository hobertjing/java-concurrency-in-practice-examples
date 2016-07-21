package net.jcip.examples.chapter07;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * BrokenPrimeProducer
 * <p/>
 * Unreliable cancellation that can leave producers stuck in a blocking operation
 * 不可靠的取消操作将把生产者置于阻塞的操作中
 */
class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                queue.put(p = p.nextProbablePrime());	//如果queue已满，该方法阻塞，则永远不会再检查 while的条件cancelled
        } catch (InterruptedException consumed) {
        }
    }

    public void cancel() {
        cancelled = true;
    }
}

//void consumePrimes() throws InterruptedException {
//	BlockingQueue<BigInteger> primes = ...;
//	BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
//	producer.start();
//	try {
//		while (needMorePrimes())
//			consume(primes.take());
//	} finally {
//		producer.cancel();
//	}
//}

