package org.rkoubsky.chapter2.singleton;

/**
 * A singleton pattern implemented using Enum.
 * This approach is functionally equivalent to the public field approach, except that it
 * is more concise, provides the serialization machinery for free, and provides an
 * ironclad guarantee against multiple instantiation, even in the face of sophisticated
 * serialization or reflection attacks
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public enum Elvis {
    INSTANCE;

    public void sing() {
        System.out.println("Singleton Elvis using enum: I am signing!");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + hashCode();
    }
}
