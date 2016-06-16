package net.jcip.examples.chapter03;

/**
 * CountingSheep
 * <p/>
 * Counting sheep
 */
public class CountingSheep {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    void countSomeSheep() {
        // One, two, three...
    }
}








