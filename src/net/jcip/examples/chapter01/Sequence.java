package net.jcip.examples.chapter01;

import net.jcip.annotations.*;

/**
 * Sequence
 */

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
