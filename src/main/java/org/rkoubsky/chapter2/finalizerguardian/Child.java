package org.rkoubsky.chapter2.finalizerguardian;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Child extends Parent {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing child class: " + Child.class);
    }
}
