package org.rkoubsky.chapter5.reduction.withoutgenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ReductionWithoutGenericsDemo {
    public static void main(final String[] args) {
        final List list = new ArrayList();
        list.add("John");
        list.add(Integer.valueOf(5));
        list.add(Integer.valueOf(7));

        System.out.println("Counting sum of all values within the raw, type-unsafe list: " + list);
        // This throws ClassCastException as we try to cast String to Integer.
        System.out.println(Reduction.reduceWithoutGenericsThreadSafe(list,
                (arg1, arg2) -> (Integer) arg1 + (Integer) arg2, Integer.valueOf(0)));
    }
}
