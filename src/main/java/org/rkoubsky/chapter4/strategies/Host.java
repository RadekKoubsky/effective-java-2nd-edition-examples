package org.rkoubsky.chapter4.strategies;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Because the strategy interface serves as a type for all of its concrete strategy
 * instances, a concrete strategy class needn’t be made public to export a concrete
 * strategy. Instead, a “host class” can export a public static field (or static factory
 * method) whose type is the strategy interface, and the concrete strategy class can
 * be a private nested class of the host. In the example that follows, a static member
 * class is used in preference to an anonymous class to allow the concrete strategy
 * class to implement a second interface, Serializable
 * <p>
 * Exporting a concrete strategy
 * </p>
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Host {
    private static class StrLenCmp
            implements Comparator<String>, Serializable {
        @Override
        public int compare(final String s1, final String s2) {
            return s1.length() - s2.length();
        }
    }

    // Returned comparator is serializable
    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
}
