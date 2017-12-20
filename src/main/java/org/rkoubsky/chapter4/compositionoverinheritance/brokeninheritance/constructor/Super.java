package org.rkoubsky.chapter4.compositionoverinheritance.brokeninheritance.constructor;

/**
 * Constructors must not invoke overridable methods, directly or indirectly. If
 * you violate this rule, program failure will result. The superclass constructor runs
 * before the subclass constructor, so the overriding method in the subclass will get
 * invoked before the subclass constructor has run. If the overriding method depends
 * on any initialization performed by the subclass constructor, the method will not
 * behave as expected.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Super {
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
