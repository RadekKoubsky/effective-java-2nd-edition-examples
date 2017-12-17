package org.rkoubsky.chapter3.equals.violations.liskovsubstitution;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(final int x, final int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public int numberCreated(){
        return counter.get();
    }

    @Override
    public String toString() {
        return "CounterPoint{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
