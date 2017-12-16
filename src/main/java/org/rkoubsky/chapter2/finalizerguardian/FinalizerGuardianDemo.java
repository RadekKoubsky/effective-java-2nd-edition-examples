package org.rkoubsky.chapter2.finalizerguardian;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class FinalizerGuardianDemo {
    public static void main(final String[] args) throws InterruptedException {
        printChild();
        System.gc();
        //Thread.sleep(5000);
    }

    private static void printChild() {
        final Child child = new Child();
        System.out.println("Printing child: " + child);
    }
}
