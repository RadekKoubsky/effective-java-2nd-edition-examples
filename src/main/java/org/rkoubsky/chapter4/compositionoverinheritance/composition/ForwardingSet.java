package org.rkoubsky.chapter4.compositionoverinheritance.composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * A forwarding class, which, contains all of the forwarding methods and nothing else.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(final Set<E> s) {
        this.s = s;
    }

    @Override
    public void clear() {
        this.s.clear();
    }

    @Override
    public boolean contains(final Object o) {
        return this.s.contains(o);
    }

    @Override
    public boolean isEmpty() {
        return this.s.isEmpty();
    }

    @Override
    public int size() {
        return this.s.size();
    }

    @Override
    public Iterator<E> iterator() {
        return this.s.iterator();
    }

    @Override
    public boolean add(final E e) {
        return this.s.add(e);
    }

    @Override
    public boolean remove(final Object o) {
        return this.s.remove(o);
    }


    @Override
    public boolean containsAll(final Collection<?> c) {
        return this.s.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        return this.s.addAll(c);
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return this.s.removeAll(c);
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return this.s.retainAll(c);
    }

    @Override
    public Object[] toArray() {
        return this.s.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return this.s.toArray(a);
    }

    @Override
    public boolean equals(final Object o) {
        return this.s.equals(o);
    }

    @Override
    public int hashCode() {
        return this.s.hashCode();
    }

    @Override
    public String toString() {
        return this.s.toString();
    }
}
