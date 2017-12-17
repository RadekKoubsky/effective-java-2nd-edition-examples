package org.rkoubsky.chapter3.equals.composition;

import java.awt.*;

/**
 * Follow the advice of Item 16, “Favor composition over inheritance.”
 * Instead of having ColorPoint extend Point, give
 * ColorPoint a private Point field and a public view method (Item 5) that returns
 * the point at the same position as this color point
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(final int x, final int y, final Color color) {
        if (color == null) {
            throw new NullPointerException();
        }
        this.point = new Point(x, y);
        this.color = color;
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return this.point;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        final ColorPoint colorPoint = (ColorPoint) o;
        return colorPoint.point.equals(this.point) && colorPoint.color == this.color;
    }

    @Override
    public int hashCode() {
        int result = this.point.hashCode();
        result = 31 * result + this.color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ColorPoint{" +
                "x=" + this.point.getX() +
                ", y=" + this.point.getY() +
                ", color=" + this.color +
                '}';
    }
}
