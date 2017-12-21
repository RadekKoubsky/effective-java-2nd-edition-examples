package org.rkoubsky.chapter5.reduction.withgenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Reduction {
    // Naive generic version of reduction - won't compile! Unless you cast (E[]) list.toArray()
    static <E> E reduceWithArray(final List<E> list, final Function<E> f, final E initVal) {
        final E[] snapshot = (E[]) list.toArray(); // Locks list
        E result = initVal;
        for (final E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

    // List-based generic reduction
    static <E> E reduceWithList(final List<E> list, final Function<E> f, final E initVal) {
        final List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>(list);
        }
        E result = initVal;
        for (final E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }
}
