package org.rkoubsky.chapter2.spi;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Executing service created by a service provider.");
    }
}
