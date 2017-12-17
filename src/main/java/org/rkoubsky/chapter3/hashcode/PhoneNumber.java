package org.rkoubsky.chapter3.hashcode;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(final int areaCode, final int prefix,
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
        if(!(o instanceof PhoneNumber)) {
            return false;
        }
        final PhoneNumber that = (PhoneNumber) o;
        return this.areaCode == that.areaCode &&
                this.prefix == that.prefix &&
                this.lineNumber == that.lineNumber;
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + this.areaCode;
        result = 31 * result + this.prefix;
        result = 31 * result + this.lineNumber;
        return result;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode=" + this.areaCode +
                ", prefix=" + this.prefix +
                ", lineNumber=" + this.lineNumber +
                '}';
    }
}
