package org.rkoubsky.chapter3.clonable;

import org.rkoubsky.chapter3.clonable.phonenumber.PhoneNumberCloneable;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StackCloneable implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackCloneable() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(final Object e) {
        ensureCapacity();
        this.elements[this.size++] = e;
    }

    public Object pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        final Object result = this.elements[--this.size];
        this.elements[this.size] = null; // Eliminate obsolete reference
        return result;
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (this.elements.length == this.size) {
            this.elements = Arrays.copyOf(this.elements, 2 * this.size + 1);
        }
    }

    /**
     * If an object contains fields that refer to mutable objects, using the simple
     * clone implementation from {@link PhoneNumberCloneable#clone()} can be disastrous.
     * <p>
     * Suppose you want to make this class cloneable. If its clone method merely
     * returns super.clone(), the resulting StackClonable instance will have the correct value in
     * its size field, but its elements field will refer to the same array as the original
     * Stack instance. Modifying the original will destroy the invariants in the clone and
     * vice versa. You will quickly find that your program produces nonsensical results
     * or throws a NullPointerException .
     * </p>
     * <p>
     * We need to copy the internals of this class to implement the clone method properly.
     * </p>
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            final StackCloneable result = (StackCloneable) super.clone();
            result.elements = this.elements.clone();
            return result;
        } catch (final CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
