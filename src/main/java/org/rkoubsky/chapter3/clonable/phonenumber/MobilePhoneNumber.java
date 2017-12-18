package org.rkoubsky.chapter3.clonable.phonenumber;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class MobilePhoneNumber extends PhoneNumberCloneable {
    public MobilePhoneNumber(final int areaCode, final int prefix, final int lineNumber) {
        super(areaCode, prefix, lineNumber);
    }

    /**
    * If the {@link PhoneNumberCloneable#clone()} method would use constructor
    * 'return new PhoneNumberCloneable(this.areaCode, this.prefix, this.lineNumber);' instead
    * of super.clone(), it would break the general requirement on the clone method:
    * <p>
    * this.getClass() is identical to this.clone().getClass()
    * </p>
     * as this.clone().getClass() would return {@link PhoneNumberCloneable}
    * */
    @Override
    public PhoneNumberCloneable clone() {
        return super.clone();
    }
}
