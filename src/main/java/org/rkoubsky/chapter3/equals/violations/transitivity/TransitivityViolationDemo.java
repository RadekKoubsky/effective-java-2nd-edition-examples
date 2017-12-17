package org.rkoubsky.chapter3.equals.violations.transitivity;

import java.awt.*;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class TransitivityViolationDemo {
    public static void main(final String[] args) {
        final ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        final Point p2 = new Point(1, 2);
        final ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        /*
        Calling p1.equals(p2) and p2.equals(p3) return true , while p1.equals(p3)
        returns false, a clear violation of transitivity. The first two comparisons are
        “color-blind,” while the third takes color into account.
        * */
        System.out.printf("Calling %s equals %s\n", p1, p2);
        System.out.println("Result: " + p1.equals(p2));

        System.out.printf("Calling %s equals %s\n", p2, p3);
        System.out.println("Result: " + p2.equals(p3));

        System.out.printf("Calling %s equals %s\n", p1, p3);
        System.out.println("Result: " + p1.equals(p3));
    }
}
