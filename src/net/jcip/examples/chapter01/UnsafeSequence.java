package net.jcip.examples.chapter01;

import net.jcip.annotations.*;

/**
 * UnsafeSequence
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}
