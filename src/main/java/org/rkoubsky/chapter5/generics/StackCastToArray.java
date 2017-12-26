package org.rkoubsky.chapter5.generics;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StackCastToArray<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    public StackCastToArray() {
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(final E e) {
        ensureCapacity();
        this.elements[this.size++] = e;
    }

    public E pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        final E result = this.elements[--this.size];
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
