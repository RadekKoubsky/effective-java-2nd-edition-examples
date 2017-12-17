package org.rkoubsky.chapter3.equals.violations.liskovsubstitution;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class LiskovViolationDemo {
    public static void main(final String[] args) {
        final Point point = new Point( 1, 0);
        final Point counterPoint = new CounterPoint(1, 0);
        System.out.printf("Calling %s equals %s\n", counterPoint, point);
        System.out.println("Result: " + counterPoint.equals(point));
    }
}
