package org.rkoubsky.chapter5.reduction.withgenerics;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Function<T> {
    public T apply(T arg1, T arg2);
}
