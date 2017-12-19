package org.rkoubsky.chapter4.compositionoverinheritance.brokeninheritance;

import java.util.Arrays;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BrokenInstrumentedHashSetDemo {
    public static void main(final String[] args) {
        final BrokenInstrumentedHashSet<String> names = new BrokenInstrumentedHashSet<>();
        names.addAll(Arrays.asList("John", "Alice", "Joshua"));
        System.out.println("Expected 3 elements added into set: " + names);
        /*
        * We get 6 additions as addAll method is implemented on the top of add(E e) method,
        * thus we counted twice. See BrokenInstrumentedHashSet class.
        * */
        System.out.println("Getting counter of elements added: " + names.getAddCount());
    }
}
