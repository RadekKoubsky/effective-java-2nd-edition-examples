package org.rkoubsky.chapter2.finalizerguardian;

/**
 * This class shows the Finalizer Guardian idiom.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Parent {
    /*
    Sole purpose of this object is to finalize outer Parent object

    A single instance of the anonymous class, called a finalizer guardian, is created for each instance of the
    enclosing class. The enclosing instance stores the sole reference to its finalizer
    guardian in a private instance field so the finalizer guardian becomes eligible for
    finalization at the same time as the enclosing instance. When the guardian is
    finalized, it performs the finalization activity desired for the enclosing instance,
    just as if its finalizer were a method on the enclosing class
    */
    private final Object finalizerGuardian = new Object(){
        @Override
        protected void finalize() throws Throwable {
            doFinalize();
        }
    };

    private void doFinalize() {
        System.out.println("Finalizing parent class: " + Parent.class);
    }
}
