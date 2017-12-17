package org.rkoubsky.chapter3.equals.violations.symmetry;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CaseInsensitiveString {
    private final String s;
    public CaseInsensitiveString(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override public boolean equals(final Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(this.s);
    }

    @Override
    public int hashCode() {
        return this.s != null ? this.s.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CaseInsensitiveString{" +
                "s='" + this.s + '\'' +
                '}';
    }
}
