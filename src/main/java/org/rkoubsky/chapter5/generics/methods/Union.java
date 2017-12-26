package org.rkoubsky.chapter5.generics.methods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Union {
    public static void main(final String[] args) {
        final Set<String> guys = new HashSet<>(
                Arrays.asList("Tom", "John", "Harry"));
        final Set<String> stooges = new HashSet<>(
                Arrays.asList("Larry", "Moe", "Curly"));
        final Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);

    }

    /**
     * One noteworthy feature of generic methods is that you needn’t specify the
     * value of the type parameter explicitly as you must when invoking generic con-
     * structors. The compiler figures out the value of the type parameters by examining
     * the types of the method arguments. In the case of the program above, the compiler
     * sees that both arguments to union are of type Set&lt;String&gt; , so it knows that the
     * type parameter E must be String. This process is called type inference.
     */
    public static <E> Set<E> union(final Set<E> set1, final Set<E> set2) {
        final Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}
