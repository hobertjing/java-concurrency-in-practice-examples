package net.jcip.examples.chapter05;

import java.util.*;

import net.jcip.annotations.NotThreadSafe;

/**
 * UnsafeVectorHelpers
 * <p/>
 * Compound actions on a Vector that may produce confusing results
 */
@NotThreadSafe
public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
