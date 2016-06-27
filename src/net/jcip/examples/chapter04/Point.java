package net.jcip.examples.chapter04;

import net.jcip.annotations.*;

/**
 * Point
 * <p/>
 * Immutable Point class used by DelegatingVehicleTracker
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
