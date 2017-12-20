package org.rkoubsky.chapter4.hiearchiesovertaggedclasses.hierarchy;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Rectangle extends Figure {
    private final double width;
    private final double length;

    public Rectangle(final double width, final double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }
}
