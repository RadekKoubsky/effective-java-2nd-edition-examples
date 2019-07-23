package org.rkoubsky.chapter7.defensive.copies;

import java.util.Date;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PeriodBrokenImmutabilityDemo {
    public static void main(String[] args) {
        // Attack the internals of a Period instance
        Date start = new Date();
        Date end = new Date();
        PeriodBrokenImmutability p = new PeriodBrokenImmutability(start, end);
        System.out.println("Period instance before changing mutable end date passed in constructor: " + p);
        end.setYear(78); // Modifies internals of p!
        System.out.println("Period instance after changing mutable end date passed in constructor: " + p);

        System.out.println("\n");

        // Second attack on the internals of a Period instance
        Date start2 = new Date();
        Date end2 = new Date();
        PeriodBrokenImmutability p2 = new PeriodBrokenImmutability(start2, end2);
        System.out.println("Period instance before changing mutable end date returned by getter: " + p2);
        p2.end().setYear(54); // Modifies internals of p!
        System.out.println("Period instance after changing mutable end date returned by getter: " + p2);
    }
}
