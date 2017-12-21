package org.rkoubsky.chapter5.reduction.withgenerics;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ReductionWithGenericsDemo {
    public static void main(final String[] args) {
        final List<Integer> typeSafeList = new ArrayList<>();
        typeSafeList.add(3);
        typeSafeList.add(5);
        typeSafeList.add(7);
        System.out.println("Counting sum of all values within the generic, type-safe list: " + typeSafeList);
        System.out.println(Reduction.reduceWithList(typeSafeList, (arg1, arg2) -> arg1 + arg2, 0));

        System.out.println("Counting sum of all value within a list using stream and reduce.");
        System.out.println("Result of stream and reduce: " + typeSafeList.stream()
                .reduce((integer, integer2) -> integer + integer2).get());

        final List unsafeList = new ArrayList();
        unsafeList.add("John");
        unsafeList.add(Integer.valueOf(5));
        unsafeList.add(Integer.valueOf(7));

        System.out.println("Counting sum of all values within the raw, type-unsafe list: " + unsafeList);
        // This throws ClassCastException as we try to cast String to Integer.
        System.out.println(Reduction
                .reduceWithArray(unsafeList, (arg1, arg2) -> arg1 + arg2, Integer.valueOf(0)));
    }
}
