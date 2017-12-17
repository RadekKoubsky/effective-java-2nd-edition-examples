package org.rkoubsky.chapter3.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NotOverriddenHashCodeDemo {
    public static void main(final String[] args) {
        final Map<PhoneNumberNotOverriddenHashCode, String> map = new HashMap<>();
        final PhoneNumberNotOverriddenHashCode phoneNumber = new PhoneNumberNotOverriddenHashCode(707, 867, 5309);
        final PhoneNumberNotOverriddenHashCode equalNumber = new PhoneNumberNotOverriddenHashCode(707, 867, 5309);
        map.put(phoneNumber, "Jenny");
        System.out.printf("Result of getting a value with key %s: %s\n", equalNumber,
                map.get(equalNumber));
        System.out.printf("Calling %s equals %s\n", phoneNumber, equalNumber);
        System.out.println("Result: " + phoneNumber.equals(equalNumber));
        System.out.printf("%s hashcode: %s\n",phoneNumber, phoneNumber.hashCode());
        System.out.printf("%s hashcode: %s\n",equalNumber, equalNumber.hashCode());

    }
}
