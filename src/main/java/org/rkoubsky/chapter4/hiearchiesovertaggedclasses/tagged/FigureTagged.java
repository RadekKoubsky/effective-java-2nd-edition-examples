package org.rkoubsky.chapter4.hiearchiesovertaggedclasses.tagged;

/**
 * Tagged class - vastly inferior to a class hierarchy!
 * <p>
 * tagged classes are seldom appropriate. If you’re tempted to write
 * a class with an explicit tag field, think about whether the tag could be eliminated
 * and the class replaced by a hierarchy. When you encounter an existing class with a
 * tag field, consider refactoring it into a hierarchy
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class FigureTagged {
    enum Shape {
        RECTANGLE, CIRCLE
    }

    // Tag field - the shape of this figure
    final Shape shape;
    // These fields are used only if shape is RECTANGLE
    private double length;
    private double width;
    // This field is used only if shape is CIRCLE
    private double radius;

    // Constructor for circle
    public FigureTagged(final double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    public FigureTagged(final double length, final double width) {
        this.shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    public double area() {
        switch (this.shape) {
            case RECTANGLE:
                return this.length * this.width;
            case CIRCLE:
                return Math.PI * (this.radius * this.radius);
            default:
                throw new AssertionError();
        }
    }
}
