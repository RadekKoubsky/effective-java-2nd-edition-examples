package org.rkoubsky.chapter3.equals.violations.liskovsubstitution;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Point {
    private final int x;
    private final int y;
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    // Broken - violates Liskov substitution principle
    @Override public boolean equals(final Object o) {
        /*
        Uses a getClass-based equals method,
        the equals method will return false regardless of
        the CounterPoint instance’s x and y values.

        Correct solution that will return true
        if(!(o instanceof Point)){
            return false;
        }
        * */
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        final Point point = (Point) o;
        return point.x == this.x && point.y == this.y;
    }

    @Override
    public int hashCode() {
        int result = this.x;
        result = 31 * result + this.y;
        return result;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }
}
