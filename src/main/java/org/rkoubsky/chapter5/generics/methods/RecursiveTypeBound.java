package org.rkoubsky.chapter5.generics.methods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class RecursiveTypeBound {
    public static void main(final String[] args) {
        final List<Integer> ints = Arrays.asList(3, 6, 7, 8, 9, 23);
        System.out.println("Printing max of the list using generic method: " + ints);
        System.out.println(max(ints));
        System.out.println("Printing max of the list using stream max function: " + ints);
        System.out.println(ints.stream().max(Comparator.naturalOrder()).get());
    }

    /**
     * Takes a list of elements that implements Comparable interface, it is required that every element in the list
     * be comparable to every other element in the list, in other words, that the elements
     * of the list be mutually comparable.
     * The type bound <T extends Comparable<T>> may be read as “for every type T
     * that can be compared to itself,” which corresponds more or less exactly to the
     * notion of mutual comparability.
     */
    public static <T extends Comparable<T>> T max(final List<T> list) {
        final Iterator<T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            final T element = iterator.next();
            if (element.compareTo(result) > 0) {
                result = element;
            }
        }
        return result;
    }
}
