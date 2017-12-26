package org.rkoubsky.chapter5.generics;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class GenericStackDemo {
    public static void main(final String[] args) {
        final StackCastToArray<String> stackCastToArray = new StackCastToArray<>();
        final StackCastToScalar<String> stackCastToScalar = new StackCastToScalar<>();
        final String word = "Hello";

        for (final char literal : word.toCharArray()) {
            stackCastToArray.push(Character.toString(literal));
            stackCastToScalar.push(Character.toString(literal));
        }

        System.out.println("Printing StackCastToArray:");
        while (!stackCastToArray.isEmpty()) {
            System.out.println(stackCastToArray.pop());
        }

        System.out.println("Printing StackCastToScalar:");
        while (!stackCastToScalar.isEmpty()) {
            System.out.println(stackCastToScalar.pop());
        }
    }
}
