package org.rkoubsky.chapter3.equals.violations.symmetry;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CaseInsensitiveStringBroken {
    private final String s;
    public CaseInsensitiveStringBroken(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }
    // Broken - violates symmetry!
    @Override public boolean equals(final Object o) {
        if (o instanceof CaseInsensitiveStringBroken) {
            return this.s.equalsIgnoreCase(
                    ((CaseInsensitiveStringBroken) o).s);
        }
        if (o instanceof String) // One-way interoperability!
        {
            return this.s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.s != null ? this.s.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CaseInsensitiveStringBroken{" +
                "s='" + this.s + '\'' +
                '}';
    }
}
