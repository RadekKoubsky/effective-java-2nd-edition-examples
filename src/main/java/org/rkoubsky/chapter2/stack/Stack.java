package org.rkoubsky.chapter2.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Stack {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size = 0;
    private Object[] elements;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public static void main(final String[] args) {
        final Stack stack = new Stack();
        stack.push("First element.");
        stack.push("Second element");
        System.out.println("Array of elements within the stack before pop operation: " + Arrays.asList(stack.elements));
        System.out.println("Popping the second element off the stack: " + stack.pop());
        System.out.println("Array of elements within the stack after pop operation: " + Arrays.asList(stack.elements));
    }

    public void push(final Object element) {
        ensureCapacity();
        this.elements[this.size++] = element;
    }

    public Object pop() throws EmptyStackException {
        if(this.size == 0){
            throw new EmptyStackException();
        }
        final Object result = this.elements[--this.size];
        /*
         Memory leaks in garbage-collected languages (more properly known as unin-
         tentional object retentions) are insidious. If an object reference is unintentionally
         retained, not only is that object excluded from garbage collection, but so too are
         any objects referenced by that object, and so on. Even if only a few object refer-
         ences are unintentionally retained, many, many objects may be prevented from
         being garbage collected, with potentially large effects on performance.
         The fix for this sort of problem is simple: null out references once they
         become obsolete.
         */
        // Eliminate obsolete reference
        this.elements[this.size] = null;
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        this.elements = Arrays.copyOf(this.elements, this.size * 2 + 1);
    }
}
