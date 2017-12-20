package org.rkoubsky.chapter4.compositionoverinheritance.brokeninheritance.constructor;

import java.util.Date;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BrokenSuperClassConstructorDemo {
    public static void main(final String[] args) {
        // this will print null as superclass constructor is invoked before subclass constructor
        final Sub subClass = new Sub(new Date());
        subClass.overrideMe();
    }
}
