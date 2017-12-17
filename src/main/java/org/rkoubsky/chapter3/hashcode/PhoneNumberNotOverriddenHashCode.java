package org.rkoubsky.chapter3.hashcode;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PhoneNumberNotOverriddenHashCode {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumberNotOverriddenHashCode(final int areaCode, final int prefix,
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
        if(!(o instanceof PhoneNumberNotOverriddenHashCode)){
            return false;
        }
        final PhoneNumberNotOverriddenHashCode that = (PhoneNumberNotOverriddenHashCode) o;
        return this.areaCode == that.areaCode &&
                this.prefix == that.prefix &&
                this.lineNumber == that.lineNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumberNotOverriddenHashCode{" +
                "areaCode=" + this.areaCode +
                ", prefix=" + this.prefix +
                ", lineNumber=" + this.lineNumber +
                '}';
    }
}
