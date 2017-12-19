package org.rkoubsky.chapter4.compositionoverinheritance.brokeninheritance;

import java.util.Collection;
import java.util.HashSet;

/**
 * Broken subclass - inappropriate use of inheritance
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BrokenInstrumentedHashSet<E> extends HashSet<E> {
    // The number of elements added
    private int addCount = 0;

    public BrokenInstrumentedHashSet() {
    }

    public BrokenInstrumentedHashSet(final int initialCapacity, final float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(final E e) {
        this.addCount++;
        return super.add(e);
    }

    /**
     * This will result into {@code addCount} multiplied by 2 as the super class's {@link HashSet#addAll(Collection)}
     * method is implemented on top of the {@link HashSet#add(Object)} method, which add one more count to {@code addCount}
     */
    @Override
    public boolean addAll(final Collection<? extends E> c) {
        this.addCount += c.size();
        // this calls add method in this class for each element in collection c
        return super.addAll(c);
    }

    public int getAddCount() {
        return this.addCount;
    }
}
