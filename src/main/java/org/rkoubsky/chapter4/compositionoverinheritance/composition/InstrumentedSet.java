package org.rkoubsky.chapter4.compositionoverinheritance.composition;

import java.util.Collection;
import java.util.Set;

/**
 * The InstrumentedSet class is known as a wrapper class because each InstrumentedSet
 * instance contains (“wraps”) another Set instance. This is also
 * known as the Decorator pattern, because the Instrumented-
 * Set class “decorates” a set by adding instrumentation.
 * <p>
 * <p>
 * Not only are wrapper classes more robust than subclasses, they are also more powerful.
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(final Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(final E e) {
        this.addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        this.addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return this.addCount;
    }
}
