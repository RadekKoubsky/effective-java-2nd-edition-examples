package org.rkoubsky.chapter7.defensive.copies;

import java.util.Date;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ImmutablePeriod {
    private final Date start;
    private final Date end;

    /**
     * Repaired constructor - makes defensive copies of parameters
     *
     * NOTE Create defensive copies before parameter check:
     *
     * Note that defensive copies are made before checking the
     * validity of the parameters (Item 38), and the validity check is performed on
     * the copies rather than on the originals. While this may seem unnatural, it is nec-
     * essary. It protects the class against changes to the parameters from another thread
     * during the “window of vulnerability” between the time the parameters are checked
     * and the time they are copied. (In the computer security community, this is known
     * as a time-of-check/time-of-use or TOCTOU attack
     *
     * NOTE Do not use clone method
     *
     * Note also that we did not use Date ’s clone method to make the defensive cop-
     * ies. Because Date is nonfinal, the clone method is not guaranteed to return an
     * object whose class is java.util.Date : it could return an instance of an untrusted
     * subclass specifically designed for malicious mischief. Such a subclass could, for
     * example, record a reference to each instance in a private static list at the time of its
     * creation and allow the attacker to access this list. This would give the attacker free
     * reign over all instances. To prevent this sort of attack, do not use the clone
     * method to make a defensive copy of a parameter whose type is subclassable
     * by untrusted parties.
     */
    public ImmutablePeriod(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);

    }

    // Repaired accessors - make defensive copies of internal fields
    public Date start() {
        return new Date(start.getTime());
    }

    // Repaired accessors - make defensive copies of internal fields
    public Date end() {
        return new Date(end.getTime());
    }
}
