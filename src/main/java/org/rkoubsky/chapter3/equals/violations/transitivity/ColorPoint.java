package org.rkoubsky.chapter3.equals.violations.transitivity;

import java.awt.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ColorPoint extends Point {
    private final Color color;
    public ColorPoint(final int x, final int y, final Color color) {
        super(x, y);
        this.color = color;
    }

    // Broken - violates transitivity!
    @Override
    public boolean equals(final Object o) {
        if(!(o instanceof Point)){
            return false;
        }

        // If o is a normal Point, do a color-blind comparison
        if(!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color == this.color;
    }

    @Override
    public int hashCode() {
        return this.color != null ? this.color.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ColorPoint{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", color=" + this.color +
                '}';
    }
}
