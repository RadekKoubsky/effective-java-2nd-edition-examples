package org.rkoubsky.chapter4.compositionoverinheritance.composition;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CompositionDemo {
    public static void main(final String[] args) {
        final InstrumentedSet<String> names = new InstrumentedSet<>(new HashSet<>());
        names.addAll(Arrays.asList("John", "Alice", "Joshua"));
        System.out.println("Expected 3 elements added into set: " + names);
        System.out.println("Getting counter of elements added: " + names.getAddCount());
    }
}
