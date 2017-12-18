package org.rkoubsky.chapter3.clonable.phonenumber;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class PhoneNumberCloneableDemo {
    public static void main(final String[] args) {
        final PhoneNumberCloneable phoneNumber = new MobilePhoneNumber(555, 762, 2876);
        final PhoneNumberCloneable clone = phoneNumber.clone();
        System.out.printf("Original phone number object: %s, class: %s\n", phoneNumber, phoneNumber.getClass());
        System.out.printf("Cloned phone number object: %s, class: %s", clone, clone.getClass());
    }
}
