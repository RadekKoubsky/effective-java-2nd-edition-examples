package org.rkoubsky.chapter3.equals.composition;

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
    @Override public boolean equals(final Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        final Point p = (Point)o;
        return p.x == this.x && p.y == this.y;
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
}
