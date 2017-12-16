package org.rkoubsky.chapter2.spi;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ProviderImpl implements Provider {
    @Override
    public Service newService() {
        return new ServiceImpl();
    }
}
