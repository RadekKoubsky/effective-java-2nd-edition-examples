package org.rkoubsky.chapter2.spi;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ServiceProviderDemo {
    public static void main(final String[] args) {
        final String providerName = "MyCustomProvider";
        Services.registerProvider(providerName, new ProviderImpl());
        System.out.println("Calling service via service provider interface...");
        System.out.println("Result: ");
        Services.getService(providerName).execute();
    }
}
