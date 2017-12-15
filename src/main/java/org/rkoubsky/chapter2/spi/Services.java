package org.rkoubsky.chapter2.spi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Services {
    private static final String DEFAULT_PROVIDER_NAME = "<def>";
    // maps service names to services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    //prevent instantiation
    private Services(){

    }

    // Provider registration API
    public void registerDefaultProvider(Provider provider){
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    public void registerProvider(String name, Provider provider){
        providers.put(name, provider);
    }

    // Service access API
    public Service getDefaultService(){
        return getService(DEFAULT_PROVIDER_NAME);
    }

    public Service getService(String providerName){
        Provider provider = providers.get(providerName);
        if(provider == null){
            throw new IllegalArgumentException("No provider registered with name: " + providerName);
        }
        return provider.newService();
    }
}
