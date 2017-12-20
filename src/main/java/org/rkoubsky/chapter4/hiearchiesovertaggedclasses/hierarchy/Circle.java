package org.rkoubsky.chapter4.hiearchiesovertaggedclasses.hierarchy;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Circle extends Figure {
    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (this.radius * this.radius);
    }
}
