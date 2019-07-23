package org.rkoubsky.chapter7.defensive.copies;

import java.util.Date;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PeriodBrokenImmutability {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
    public PeriodBrokenImmutability(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }

    // The returned start field is mutable
    public Date start() {
        return start;
    }

    // The returned end field is mutable
    public Date end() {
        return end;
    }

    @Override
    public String toString() {
        return "PeriodBrokenImmutability{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
