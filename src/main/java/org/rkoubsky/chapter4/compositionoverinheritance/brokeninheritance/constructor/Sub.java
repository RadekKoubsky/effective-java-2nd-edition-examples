package org.rkoubsky.chapter4.compositionoverinheritance.brokeninheritance.constructor;

import java.util.Date;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Sub extends Super {
    private final Date date;

    public Sub(final Date date) {
        this.date = date;
    }

    @Override
    public void overrideMe() {
        // When calling this method in the super class constructor (which is called before subclass constructor),
        // this.date will not be initialized, thus it prints 'null'.
        System.out.println(this.date);
    }
}
