package net.jcip.examples.chapter04;

import java.util.concurrent.atomic.AtomicInteger;

import net.jcip.annotations.NotThreadSafe;

/**
 * NumberRange
 * <p/>
 * Number range class that does not sufficiently protect its invariants
 */
@NotThreadSafe
public class NumberRange {
    // INVARIANT: lower <= upper 不变性条件
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    
    public void setLower(int i) {
        // Warning -- unsafe check-then-act
        if (i > upper.get())
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        lower.set(i);
    }

    public void setUpper(int i) {
        // Warning -- unsafe check-then-act
        if (i < lower.get())
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}

