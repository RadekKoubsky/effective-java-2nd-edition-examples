package org.rkoubsky.chapter5.generics;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StackCastToScalar<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackCastToScalar() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(final E e) {
        ensureCapacity();
        this.elements[this.size++] = e;
    }

    // Appropriate suppression of unchecked warning
    public E pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        // push requires elements to be of type E, so cast is correct
        @SuppressWarnings("unchecked") final E result = (E) this.elements[--this.size];
        this.elements[this.size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void ensureCapacity() {
        if (this.elements.length == this.size) {
            this.elements = Arrays.copyOf(this.elements, 2 * this.size + 1);
        }
    }
}
