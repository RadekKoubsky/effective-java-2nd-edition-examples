package org.rkoubsky.chapter3.clonable.phonenumber;

/**
 * In practice, a class that implements Cloneable is expected to provide a properly
 * functioning public clone method. It is not, in general, possible to do so unless
 * all of the class’s superclasses provide a well-behaved clone implementation,
 * whether public or protected
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PhoneNumberCloneable implements Cloneable {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumberCloneable(final int areaCode, final int prefix,
            final int lineNumber) {
        rangeCheck(areaCode,
                999, "area code");
        rangeCheck(prefix,
                999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(final int arg, final int max,
            final String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumberCloneable)) {
            return false;
        }
        final PhoneNumberCloneable that = (PhoneNumberCloneable) o;
        return this.areaCode == that.areaCode &&
                this.prefix == that.prefix &&
                this.lineNumber == that.lineNumber;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.areaCode;
        result = 31 * result + this.prefix;
        result = 31 * result + this.lineNumber;
        return result;
    }

    @Override
    public String toString() {
        return "PhoneNumberCloneable{" +
                "areaCode=" + this.areaCode +
                ", prefix=" + this.prefix +
                ", lineNumber=" + this.lineNumber +
                '}';
    }

    /**
     * The provision that x.clone().getClass() should generally be identical to
     * x.getClass(), however, is too weak. In practice, programmers assume that if
     * they extend a class and invoke super.clone from the subclass, the returned object
     * will be an instance of the subclass. The only way a superclass can provide this
     * functionality is to return an object obtained by calling super.clone. If a clone
     * method returns an object created by a constructor, it will have the wrong class.
     * Therefore, if you override the clone method in a nonfinal class, you should
     * return an object obtained by invoking super.clone .
     */
    @Override
    public PhoneNumberCloneable clone() {
        try {
            /*
            * Calling constructor return new PhoneNumberCloneable(this.areaCode, this.prefix, this.lineNumber);
            * will break the requirement 'x.clone().getClass() should generally be identical to
            * x.getClass()' described in the javadoc of this method.
            * */
            return (PhoneNumberCloneable) super.clone();
        } catch (final CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}
