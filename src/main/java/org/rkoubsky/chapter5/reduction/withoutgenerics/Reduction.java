package org.rkoubsky.chapter5.reduction.withoutgenerics;


import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Reduction {

    /**
     * Reduction without generics, and with concurrency flaw!
     * <p>
     * You’ve read Item 67, which tells you not to call “alien methods”
     * from a synchronized region. So, you modify the reduce method to copy the con-
     * tents of the list while holding the lock, which allows you to perform the reduction
     * on the copy.
     * </p>
     */
    public static Object reduceWithoutGenericsNonThreadSafe(final List list, final Function function,
            final Object initValue) {
        synchronized (list) {
            Object result = initValue;
            for (final Object object : list) {
                result = function.apply(result, object);
            }
            return result;
        }
    }

    // Reduction without generics or concurrency flaw
    static Object reduceWithoutGenericsThreadSafe(final List list, final Function f, final Object initVal) {
        final Object[] snapshot = list.toArray(); // Locks list internally
        Object result = initVal;
        for (final Object o : snapshot) {
            result = f.apply(result, o);
        }
        return result;
    }
}
