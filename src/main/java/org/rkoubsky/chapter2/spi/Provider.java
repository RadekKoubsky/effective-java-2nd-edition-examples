package org.rkoubsky.chapter2.spi;

/**
 * Service provider interface.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public interface Provider {
    Service newService();
}
