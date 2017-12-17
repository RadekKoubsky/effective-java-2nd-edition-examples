package org.rkoubsky.chapter3.equals.composition;


import java.awt.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CompositionDemo {
    public static void main(final String[] args) {
        final ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        final Point p2 = new Point(1, 2);
        final ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        /*
        As we use composition and correctly implement equals, we should preserve
        transitivity in the equals method.
        * */
        System.out.printf("Calling %s equals %s\n", p1, p2);
        System.out.println("Result: " + p1.equals(p2));

        System.out.printf("Calling %s equals %s\n", p2, p3);
        System.out.println("Result: " + p2.equals(p3));

        System.out.printf("Calling %s equals %s\n", p1, p3);
        System.out.println("Result: " + p1.equals(p3));
    }
}
